package com.ntu.oa.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.ntu.oa.bean.ModelResults;
public interface DynamicService {

	ModelResults addHuoju(JSONObject json, HttpServletRequest request);

	ModelResults addDyc(JSONObject json, HttpServletRequest request);

	ModelResults delHuoju(JSONObject json, HttpServletRequest request);

	ModelResults delDyc(JSONObject json, HttpServletRequest request);

	ModelResults delFinance(JSONObject json, HttpServletRequest request);

	ModelResults delLogis(JSONObject json, HttpServletRequest request);

	ModelResults upHuoju(JSONObject json, HttpServletRequest request);

	ModelResults upDyc(JSONObject json, HttpServletRequest request);

	ModelResults addFinance(MultipartFile[] files, HttpServletRequest res);

	ModelResults upFinance(MultipartFile[] files, HttpServletRequest res);

	ModelResults upLogis(MultipartFile[] files, HttpServletRequest res);

	ModelResults addLogis(MultipartFile[] files, HttpServletRequest res);

	ModelResults getHouju(JSONObject json, HttpServletRequest request);

	ModelResults getIndustry(JSONObject json, HttpServletRequest request);

	ModelResults getFinance(JSONObject json, HttpServletRequest request);

	ModelResults getService(JSONObject json, HttpServletRequest request);

}
