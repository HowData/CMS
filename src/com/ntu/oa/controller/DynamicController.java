package com.ntu.oa.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.ntu.oa.bean.ModelResults;
import com.ntu.oa.service.DynamicService;

@Controller
@RequestMapping("/dynamic")
public class DynamicController extends BaseController{
	Logger log = Logger.getLogger(AdminController.class);
	@Resource 
	private DynamicService dynamicService;
	
	/**
	 * 增加火炬动态
	 * @param request
	 * @param response
	 */
	@RequestMapping("/addHuoju")
	public void addHuoju(HttpServletRequest request,HttpServletResponse response)
	{
		log.info("addHuoju start.....");
		JSONObject json = super.initJsonParam(request);
		ModelResults results = dynamicService.addHuoju(json,request);
		results.printJson(results, response, "");
	}
	/**
	 * 增加行业动态
	 * @param request
	 * @param response
	 */
	@RequestMapping("/addDyc")
	public void addDyc(HttpServletRequest request,HttpServletResponse response)
	{
		log.info("addDyc start.....");
		JSONObject json = super.initJsonParam(request);
		ModelResults results = dynamicService.addDyc(json,request);
		results.printJson(results, response, "");
	}
	
	/**
	 * 增加金融信息
	 * @param request
	 * @param response
	 */
	@RequestMapping("/addFinance")
    public void addFinance(HttpServletRequest res, HttpServletResponse resp,
            @RequestParam(value = "file", required = false) MultipartFile[] files)
    {
        ModelResults results = dynamicService.addFinance(files,res);
        System.out.println(files);
        results.printJson(results, resp, "");
    }
	/**
	 * 增加物流信息
	 * @param request
	 * @param response
	 */
	@RequestMapping("/addLogis")
    public void addLogis(HttpServletRequest res, HttpServletResponse resp,
            @RequestParam(value = "file", required = false) MultipartFile[] files)
    {
        ModelResults results = dynamicService.addLogis(files,res);
        System.out.println(files);
        results.printJson(results, resp, "");
    }
	
	/**
	 * 删除火炬动态
	 * @param request
	 * @param response
	 */
	@RequestMapping("/delHuoju")
	public void delHuoju(HttpServletRequest request,HttpServletResponse response)
	{
		log.info("delHuoju start.....");
		JSONObject json = super.initJsonParam(request);
		ModelResults results = dynamicService.delHuoju(json,request);
		results.printJson(results, response, "");
	}
	/**
	 * 删除行业动态
	 * @param request
	 * @param response
	 */
	@RequestMapping("/delDyc")
	public void delDyc(HttpServletRequest request,HttpServletResponse response)
	{
		log.info("delDyc start.....");
		JSONObject json = super.initJsonParam(request);
		ModelResults results = dynamicService.delDyc(json,request);
		results.printJson(results, response, "");
	}
	
	/**
	 * 删除金融信息
	 * @param request
	 * @param response
	 */
	@RequestMapping("/delFinance")
	public void delFinance(HttpServletRequest request,HttpServletResponse response)
	{
		log.info("delFinance start.....");
		JSONObject json = super.initJsonParam(request);
		ModelResults results = dynamicService.delFinance(json,request);
		results.printJson(results, response, "");
	}
	/**
	 * 删除物流信息
	 * @param request
	 * @param response
	 */
	@RequestMapping("/delLogis")
	public void delLogis(HttpServletRequest request,HttpServletResponse response)
	{
		log.info("delLogis start.....");
		JSONObject json = super.initJsonParam(request);
		ModelResults results = dynamicService.delLogis(json,request);
		results.printJson(results, response, "");
	}
	
	
	/**
	 * 修改火炬动态
	 * @param request
	 * @param response
	 */
	@RequestMapping("/upHuoju")
	public void upHuoju(HttpServletRequest request,HttpServletResponse response)
	{
		log.info("upHuoju start.....");
		JSONObject json = super.initJsonParam(request);
		ModelResults results = dynamicService.upHuoju(json,request);
		results.printJson(results, response, "");
	}
	/**
	 * 修改行业动态
	 * @param request
	 * @param response
	 */
	@RequestMapping("/upDyc")
	public void upDyc(HttpServletRequest request,HttpServletResponse response)
	{
		log.info("addDyc start.....");
		JSONObject json = super.initJsonParam(request);
		ModelResults results = dynamicService.upDyc(json,request);
		results.printJson(results, response, "");
	}
	
	/**
	 * 修改金融信息
	 * @param request
	 * @param response
	 */
	@RequestMapping("/upFinance")
    public void upFinance(HttpServletRequest res, HttpServletResponse resp,
            @RequestParam(value = "file", required = false) MultipartFile[] files)
    {
        ModelResults results = dynamicService.upFinance(files,res);
        System.out.println(files);
        results.printJson(results, resp, "");
    }
	/**
	 * 修改物流信息
	 * @param request
	 * @param response
	 */
	@RequestMapping("/upLogis")
    public void upLogis(HttpServletRequest res, HttpServletResponse resp,
            @RequestParam(value = "file", required = false) MultipartFile[] files)
    {
        ModelResults results = dynamicService.upLogis(files,res);
        System.out.println(files);
        results.printJson(results, resp, "");
    }
	/**
	 * 获取火炬动态的全部信息
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/getHouju", method = RequestMethod.POST)
	public void getHouju(HttpServletRequest request,HttpServletResponse response)
	{
		JSONObject json = super.initJsonParam(request);
		ModelResults results = dynamicService.getHouju(json, request);
		results.printJson(results, response, "");
	}
	
	/**
	 * 获取行业动态的全部信息
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/getIndustry", method = RequestMethod.POST)
	public void getIndustry(HttpServletRequest request,HttpServletResponse response)
	{
		JSONObject json = super.initJsonParam(request);
		ModelResults results = dynamicService.getIndustry(json, request);
		results.printJson(results, response, "");
	}
	
	/**
	 * 获取物流金融的全部信息
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/getFinance", method = RequestMethod.POST)
	public void getFinance(HttpServletRequest request,HttpServletResponse response)
	{
		JSONObject json = super.initJsonParam(request);
		ModelResults results = dynamicService.getFinance(json, request);
		results.printJson(results, response, "");
	}
	
	/**
	 * 获取物流服务的全部信息
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/getService", method = RequestMethod.POST)
	public void getService(HttpServletRequest request,HttpServletResponse response)
	{
		JSONObject json = super.initJsonParam(request);
		ModelResults results = dynamicService.getService(json, request);
		results.printJson(results, response, "");
	}
}
