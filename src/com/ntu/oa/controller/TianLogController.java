package com.ntu.oa.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.ntu.oa.bean.ModelResults;
import com.ntu.oa.service.TianService;

@Controller
@RequestMapping("/tian")
public class TianLogController extends BaseController{
	Logger log = Logger.getLogger(AdminController.class);
	@Resource 
	private TianService tianService;
	
	/**
	 * 获取余额
	 * @param request
	 * @param response
	 */
	@RequestMapping("/getBalance")
	public void getBalance(HttpServletRequest request,HttpServletResponse response)
	{
		log.info("getBalance start.....");
		JSONObject json = super.initJsonParam(request);
		ModelResults results = tianService.getBalance(json,request);
		results.printJson(results, response, "");
	}
	/**
	 * 按日期，接口id条件获取详细
	 * @param request
	 * @param response
	 */
	@RequestMapping("/getDetil")
	public void getDetil(HttpServletRequest request,HttpServletResponse response)
	{
		log.info("getDetil start.....");
		JSONObject json = super.initJsonParam(request);
		ModelResults results = tianService.getDetil(json,request);
		results.printJson(results, response, "");
	}
	
}