package com.ntu.oa.service;

import javax.servlet.http.HttpServletRequest;
import com.alibaba.fastjson.JSONObject;
import com.ntu.oa.bean.ModelResults;

public interface LoginService {

	ModelResults login(JSONObject json, HttpServletRequest request);

}
