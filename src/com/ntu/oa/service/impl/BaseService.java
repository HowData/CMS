package com.ntu.oa.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import com.alibaba.fastjson.JSONObject;
import com.ntu.oa.bean.ModelResults;
import com.ntu.oa.bean.Page;


public class BaseService {

	Logger log = Logger.getLogger(this.getClass());

	/**
	 * 获取分页的方法
	 * 
	 * @param results
	 * @param json
	 * @return
	 */
	public ModelResults getPage(ModelResults results, JSONObject json) {
		String pageSize = json.getString("pageSize") == null ? Page.PAGE_SIZE : json.getString("pageSize");
		String pageNum = json.getString("pageNum") == null ? Page.PAGE_ONE : json.getString("pageNum").toString();
		results.setPageSize(Integer.parseInt(pageSize));
		results.setPageNum(Long.parseLong(pageNum));
		return results;
	}

	/**
	 * 判断用户是否出现异地的情况
	 */
	@SuppressWarnings("unchecked")
	public static boolean isLogin(HttpServletRequest request) {
		ServletContext application = request.getServletContext();
		Map<String, Object> userInfo = (Map<String, Object>) request.getSession().getAttribute("userInfo");
		if (userInfo == null) {
			return false;
		} else {
			String phone = (String) userInfo.get("phone");
			String ssid = (String) application.getAttribute(phone);
			if (ssid == null) {
				return false;
			} else {
				String sessionId = request.getSession().getId();
				if (ssid.equals(sessionId)) {
					return true;
				} else {
					return false;
				}
			}
		}
	}

	/**
	 * 将链接转换成urlEncode编码
	 * 
	 * @param url
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String urlEncode(String url) throws UnsupportedEncodingException {
		String newUrl = java.net.URLEncoder.encode(url, "utf-8");
		return newUrl;
	}

	
}
