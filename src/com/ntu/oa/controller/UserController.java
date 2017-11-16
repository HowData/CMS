package com.ntu.oa.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.ntu.oa.bean.ModelResults;
import com.ntu.oa.util.msgUtil.AbsRestClient;
import com.ntu.oa.util.msgUtil.JsonReqClient;
import com.ntu.oa.util.msgUtil.LetterInfo;
import com.ntu.oa.util.msgUtil.MsgInfo;
import com.ntu.oa.util.msgUtil.XmlReqClient;

import common.Logger;

@Controller
@RequestMapping("/util")
public class UserController extends BaseController {
	Logger log = Logger.getLogger(UserController.class);
	private String accountSid;
	private String authToken;

	public String getAccountSid() {
		return accountSid;
	}

	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	static AbsRestClient InstantiationRestAPI(boolean enable) {
		if (enable) {
			return new JsonReqClient();
		} else {
			return new XmlReqClient();
		}
	}

	private Color getRandColor(int fc, int bc) {
		Random random = new Random();
        if(fc>255)
            fc = 255;
        if(bc>255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r,g,b);
	}
	
	@SuppressWarnings("unchecked")
	public static String testTemplateSMS(boolean json, String accountSid, String authToken, String appId,
			String templateId, String to, String param) {
		String respCode = null;
		try {
			String result = InstantiationRestAPI(json).templateSMS(accountSid, authToken, appId, templateId, to, param);
			JSONObject jsStr = JSONObject.parseObject(result);
			Map<String, Object> resp = (Map<String, Object>) jsStr.get("resp");
			respCode = (String) resp.get("respCode");
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return respCode;
	}
/**
 * 短信验证码实现
 * @param request
 * @param response
 */
	@RequestMapping("/message")
	public void addVehicleModel(HttpServletRequest request, HttpServletResponse response) {
		JSONObject json = super.initJsonParam(request);
		ModelResults results = new ModelResults();
		boolean json1 = true;
		String accountSid = "60af4908018f0a720b73c8aa48b18dd9";
		String token = "42d4122a275efa707befe86ae05ef2df";
		String appId = "bd170c42eef94a0885b8b38a8342d12d";
		String templateId = "193520";
		String to = json.getString("phone");
		int random = (int) ((Math.random() * 9 + 1) * 100000);
		String para = String.valueOf(random);
		String respCode = testTemplateSMS(json1, accountSid, token, appId, templateId, to, para);// 短信发送接口
		if (respCode != null && respCode.equals("000000")) {
			results.setData(random);
			results.setCode(MsgInfo.a_suc_code);
			results.setMessage(LetterInfo.a_suc_codeMsg);
			
		} else {
			results.setCode(MsgInfo.a_error_code);
			results.setMessage(LetterInfo.a_error_codeMsg);
		}
		results.printJson(results, response, "");
	}
	
	/**
	 * 图片验证码实现
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
		@RequestMapping("/imgVerifi")
		public void getImgVerifi(HttpServletRequest request, HttpServletResponse response) throws IOException {
			int width = 78;
	        int height = 30;
	        Random random = new Random();
	        //设置response头信息
	        //禁止缓存
	        response.setContentType("image/jpeg");
	        response.setHeader("Pragma", "No-cache");
	        response.setHeader("Cache-Control", "no-cache");
	        response.setDateHeader("Expires", 0);
	        response.setHeader("Set-Cookie", "name=value; HttpOnly");
	        //生成缓冲区image类
	        BufferedImage image = new BufferedImage(width, height, 1);
	        //产生image类的Graphics用于绘制操作
	        Graphics g = image.getGraphics();
	        //Graphics类的样式
	        g.setColor((Color) this.getRandColor(200, 250));
	        g.setFont(new Font("Times New Roman",0,28));
	        g.fillRect(0, 0, width, height);
	        //绘制干扰线
	        for(int i=0;i<150;i++){
	            g.setColor((Color) this.getRandColor(130, 200));
	            int x = random.nextInt(width);
	            int y = random.nextInt(height); 
	            int x1 = random.nextInt(12);
	            int y1 = random.nextInt(12);
	            g.drawLine(x, y, x + x1, y + y1);
	        }
	        //绘制字符
	        String strCode = "";
	        char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
        			'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
        			'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	        for(int i=0;i<4;i++){
	        	String rand = String.valueOf(codeSequence[random.nextInt(36)]); 
	            strCode = strCode + rand;
	            g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
	            g.drawString(rand, 13*i+6, 28);
	        }
	        //将字符保存到session中用于前端的验证
	        request.getSession().setAttribute("strCode", strCode);
	        //request.getSession().setMaxInactiveInterval(1*60);//设置session过期时间
	        g.dispose();
	        ImageIO.write(image, "JPEG", response.getOutputStream());
	        response.getOutputStream().flush();
		}
		
		/**
		 * 验证码校验接口
		 * @param request
		 * @param response
		 */
		@RequestMapping("/isVer")
		public void isVer(HttpServletRequest request,HttpServletResponse response)
		{
			log.info("isVer start.....");
			JSONObject json = super.initJsonParam(request);
			ModelResults results = new ModelResults();
			String code = json.getString("code").toUpperCase();
			String strCode = (String) request.getSession().getAttribute("strCode");
			if(code.equals(strCode)){
				results.setCode(MsgInfo.a_suc_code);
				results.setMessage(LetterInfo.a_suc_codeMsg);
			}else{
				results.setCode(MsgInfo.a_paramExc_code_error);
				results.setMessage(LetterInfo.a_paramExc_code_errorMsg);
			}
			results.printJson(results, response, "");
		}

}
