package com.ntu.oa.service;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.ntu.oa.bean.ModelResults;
public interface TianService {

	ModelResults getBalance(JSONObject json, HttpServletRequest request);

	ModelResults getDetil(JSONObject json, HttpServletRequest request);


}
