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
import com.ntu.oa.service.AreaService;

@Controller
@RequestMapping("/area")
public class AreaContorller extends BaseController{

	Logger log = Logger.getLogger(AreaContorller.class);

	@Resource
	private AreaService areaService;
	
	/**
	 * 获取省份
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/getProvince", method = RequestMethod.POST)
	public void getProvince(HttpServletRequest request,HttpServletResponse response)
	{
		log.info("getProvince start.....");
		JSONObject json = super.initJsonParam(request);
		ModelResults results = areaService.getProvince(json, request);
		results.printJson(results, response, "");
	}
	
	/**
	 * 获取市名
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/getCity", method = RequestMethod.POST)
	public void getCity(HttpServletRequest request,HttpServletResponse response)
	{
		log.info("getCity start.....");
		JSONObject json = super.initJsonParam(request);
		ModelResults results = areaService.getCity(json, request);
		results.printJson(results, response, "");
	}
	
	/**
	 * 获取区名
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/getDistrict", method = RequestMethod.POST)
	public void getDistrict(HttpServletRequest request,HttpServletResponse response)
	{
		log.info("getDistrict start.....");
		JSONObject json = super.initJsonParam(request);
		ModelResults results = areaService.getDistrict(json, request);
		results.printJson(results, response, "");
	}
	
	/**
	 * 关键字获取地名
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/getArea", method = RequestMethod.POST)
	public void getArea(HttpServletRequest request,HttpServletResponse response)
	{
		log.info("getArea start.....");
		JSONObject json = super.initJsonParam(request);
		ModelResults results = areaService.getArea(json, request);
		results.printJson(results, response, "");
	}
	
	/**
	 * 获取全部地区存储redies
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/getAreaAll", method = RequestMethod.POST)
	public void getAreaAll(HttpServletRequest request,HttpServletResponse response)
	{
		log.info("getAreaAll start.....");
		JSONObject json = super.initJsonParam(request);
		ModelResults results = areaService.getAreaAll(json, request);
		results.printJson(results, response, "");
	}
}
