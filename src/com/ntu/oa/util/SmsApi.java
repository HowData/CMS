/*
 * Copyright (c) 2011-2012 MBP Corporation. All Rights Reserved.
 */
package com.ntu.oa.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.sf.json.JSONObject;



/**
 * 短信http接口
 */
public class SmsApi {

	/**
	 * 日志
	 */
	private final static Log logger = LogFactory.getLog(SmsApi.class);

	/**
	 * 编码格式
	 */
	private static String ENCODING = "UTF-8";

	/**
	 * 发短信(云片网络)
	 * 
	 * @param text
	 *            　短信内容　
	 * @param mobile
	 *            　接受的手机号
	 * @return 请求状态(0:正常)
	 */
	public static String sendYunpianSms(String text, String mobile) {	
//		Map<String, String> params = new HashMap<String, String>();//请求参数集合
//	    params.put("apikey", ComConstant.yunpianapikey);
//	    params.put("text", text);
//	    params.put("mobile", mobile); 
//	    return post(ComConstant.yunpiansmsurl, params);//请自行使用post方式请求,可使用Apache HttpClient

		String status = null;

		try {

			// 客户端连接初始化
			HttpClient client = new HttpClient();

			// POST参数设定
			NameValuePair[] nameValuePairs = new NameValuePair[3];
			nameValuePairs[0] = new NameValuePair("apikey",
					ComConstant.yunpianapikey);
			nameValuePairs[1] = new NameValuePair("text", text);
			nameValuePairs[2] = new NameValuePair("mobile", mobile);

			// POST路径设定
			PostMethod method = new PostMethod(
					ComConstant.yunpiansmsurl);
			method.setRequestBody(nameValuePairs);

			// 参数字符集设定：UTF-8
			HttpMethodParams param = method.getParams();
			param.setContentCharset(ENCODING);

			// 执行请求
			int rst = client.executeMethod(method);

			// 请求成功
			if (rst == HttpStatus.SC_OK) {
				JSONObject result = JSONObject.fromObject(method
								.getResponseBodyAsString());

				status = String.valueOf(result);
//				logger.info("云片网络短信请求结果：" + result.getMsg());
			} else {
				logger.info("云片网络短信请求异常：" + method.getResponseBodyAsString());
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		return status;
	}
	
	
}