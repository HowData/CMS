package com.ntu.oa.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.ntu.oa.bean.ModelResults;
import com.ntu.oa.service.BusinessService;

@Controller
@RequestMapping("/business")
public class BusinessContorller extends BaseController{

	Logger log = Logger.getLogger(BusinessContorller.class);

	@Resource
	private BusinessService businessService;
	
	/**
	 * 主页搜索接口(公司名)
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public void search(HttpServletRequest request,HttpServletResponse response)
	{
		log.info("search start.....");
		JSONObject json = super.initJsonParam(request);
		ModelResults results = businessService.search(json, request);
		results.printJson(results, response, "");
	}
	
	/**
	 * 主页搜索接口(人名)
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/searchPerson", method = RequestMethod.POST)
	public void searchPerson(HttpServletRequest request,HttpServletResponse response)
	{
		log.info("searchPerson start.....");
		JSONObject json = super.initJsonParam(request);
		ModelResults results = businessService.searchPerson(json, request);
		results.printJson(results, response, "");
	}
	
	/**
	 * 获取公司的业务消息
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/getBusinessInfo", method = RequestMethod.POST)
	public void getNews(HttpServletRequest request,HttpServletResponse response)
	{
		log.info("getBusinessInfo start.....");
		JSONObject json = super.initJsonParam(request);
		ModelResults results = businessService.getBusinessInfo(json, request);
		results.printJson(results, response, "");
	}
	
	/**
	 * 添加公司的业务消息
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/addBusinessInfo", method = RequestMethod.POST)
	public void addBusinessInfo(HttpServletRequest request,HttpServletResponse response)
	{
		log.info("getBusinessInfo start.....");
		JSONObject json = super.initJsonParam(request);
		ModelResults results = businessService.addBusinessInfo(json, request);
		results.printJson(results, response, "");
	}
	
	/**
	 * 修改公司的业务消息
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/updateBusinessInfo", method = RequestMethod.POST)
	public void updateBusinessInfo(HttpServletRequest request,HttpServletResponse response)
	{
		log.info("updateBusinessInfo start.....");
		JSONObject json = super.initJsonParam(request);
		ModelResults results = businessService.updateBusinessInfo(json, request);
		results.printJson(results, response, "");
	}
	
	/**
	 * 新增主营路线
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/addMainroute", method = RequestMethod.POST)
	public void addMainroute(HttpServletRequest request,HttpServletResponse response)
	{
		log.info("addMainroute start.....");
		JSONObject json = super.initJsonParam(request);
		ModelResults results = businessService.addMainroute(json, request);
		results.printJson(results, response, "");
	}
	
	/**
	 * 删除主营路线
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/deleteMainroute", method = RequestMethod.POST)
	public void deleteMainroute(HttpServletRequest request,HttpServletResponse response)
	{
		log.info("addMainroute start.....");
		JSONObject json = super.initJsonParam(request);
		ModelResults results = businessService.deleteMainroute(json, request);
		results.printJson(results, response, "");
	}
}
