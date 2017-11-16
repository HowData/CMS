package com.ntu.oa.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alibaba.fastjson.JSONObject;
import com.ntu.oa.bean.ModelResults;
import com.ntu.oa.service.LoginService;

@Controller
@RequestMapping("/admin")
public class LoginController extends BaseController{
	Logger log = Logger.getLogger(LoginController.class);
	@Resource 
	private LoginService loginService;
	
	/**
	 * 登录接口
	 * @param request
	 * @param response
	 */
	@RequestMapping("/login")
	public void login(HttpServletRequest request,HttpServletResponse response)
	{
		log.info("login start.....");
		JSONObject json = super.initJsonParam(request);
		ModelResults results = loginService.login(json,request);
		results.printJson(results, response, "");
	}
	
}
