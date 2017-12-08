package com.ntu.oa.service;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.ntu.oa.bean.ModelResults;

public interface AreaService {
	//获取省份
	ModelResults getProvince(JSONObject json, HttpServletRequest request);

	//获取市
	ModelResults getCity(JSONObject json, HttpServletRequest request);

	//获取区
	ModelResults getDistrict(JSONObject json, HttpServletRequest request);
}
