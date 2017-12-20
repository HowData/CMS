package com.ntu.oa.service;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.ntu.oa.bean.ModelResults;

public interface BusinessService {
	//主页搜索(公司名)
	ModelResults search(JSONObject json,HttpServletRequest request);
	//主页搜索(人名)
	ModelResults searchPerson(JSONObject json, HttpServletRequest request);
	//获取公司业务信息
	ModelResults getBusinessInfo(JSONObject json, HttpServletRequest request);
	//添加公司业务信息
	ModelResults addBusinessInfo(JSONObject json, HttpServletRequest request);
	//修改公司业务信息
	ModelResults updateBusinessInfo(JSONObject json, HttpServletRequest request);
	//新增主营路线
	ModelResults addMainroute(JSONObject json, HttpServletRequest request);
	//删除主营路线
	ModelResults deleteMainroute(JSONObject json, HttpServletRequest request);
	//发布消息
	ModelResults publishMsg(JSONObject json, HttpServletRequest request);
}
