package com.ntu.oa.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.ntu.oa.bean.ModelResults;
import com.ntu.oa.util.LetterInfo;
import com.ntu.oa.util.MsgInfo;
import com.ntu.oa.util.SmsApi;

@Controller
@RequestMapping("/sms")
public class SmsController extends BaseController {

	Logger log = Logger.getLogger(SmsController.class);

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/sends")
	public void sends(HttpServletRequest request, HttpServletResponse response) {
		JSONObject json = super.initJsonParam(request);
		ModelResults results = new ModelResults();
		try {

			String text = json.getString("text");

			int s = 0;
			int f = 0;
			ArrayList<String> fmobile = new ArrayList<String>();
			
//			String mobile = "18248760607,17551015328";
			String mobile = "18248760607,123452342";

			String respCode = SmsApi.sendYunpianSms(text, mobile);// 短信发送接口
			JSONObject rep = JSONObject.parseObject(respCode);
			List<Map<String, Object>> data = (List<Map<String, Object>>) rep.get("data");
			for (Map<String, Object> item : data) {
				String code = String.valueOf(item.get("code"));
				if ("0".equals(code)) {
					s++;
				} else {
					f++;
					fmobile.add((String) item.get("mobile"));
				}
			}
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("success", s);
			result.put("fail", f);
			result.put("fmobile", fmobile);
			results.setData(result);
			results.setCode(MsgInfo.a_suc_code);
			results.setMessage(LetterInfo.a_suc_codeMsg);
		} catch (Exception e) {
			results.setCode(MsgInfo.a_error_code);
			results.setMessage(LetterInfo.a_error_codeMsg);
		}
		results.printJson(results, response, "");
	}

}
