package com.ntu.oa.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;

/** 
 * @ClassName: BaseController 
 * @Description: 所有业务controller继承改类，提供常用功能。如：获取前端传递参数
 * @author 魏玉峰
 * @date 2017年2月9日 下午3:09:11 
 * @version  [1.0, 2017年2月9日]
 */
public class BaseController
{
	Logger log = Logger.getLogger(this.getClass()); 
	
//	public PtUserExt getUser(HttpServletRequest res)
//	{
//		return (PtUserExt)res.getSession().getAttribute(CommonParam.LOGIN_USER_SESSION_NAME);
//	}
	
	/*
	 * 获取请求参数
	 */
    public JSONObject initJsonParam(HttpServletRequest request)
    {
        JSONObject jsonObject = new JSONObject();
        byte buffer[];
        try
        {
            buffer = getRequestPostBytes(request);
            String charEncoding = request.getCharacterEncoding();
            if (charEncoding == null)
            {
                charEncoding = "UTF-8";
            }
            String param = new String(buffer, charEncoding);
            if(null == param || "".equals(param))
            {
            	param = "{}";
            }
            jsonObject = JSONObject.parseObject(param);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static byte[] getRequestPostBytes(HttpServletRequest request) throws IOException
    {
        int contentLength = request.getContentLength();
        if (contentLength < 0)
        {
            return null;
        }
        byte buffer[] = new byte[contentLength];
        for(int i = 0; i < contentLength;)
        {
            int readlen = request.getInputStream().read(buffer, i, contentLength - i);
            if (readlen == -1)
            {
                break;
            }
            i += readlen;
        }
        return buffer;
    }
}
