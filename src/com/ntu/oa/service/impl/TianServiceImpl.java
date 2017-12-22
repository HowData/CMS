package com.ntu.oa.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ntu.oa.bean.ModelResults;
import com.ntu.oa.dao.TianlogMapper;
import com.ntu.oa.service.TianService;
import com.ntu.oa.util.ComConstant;
import com.ntu.oa.util.HttpClientUtil;
import com.ntu.oa.util.LetterInfo;
import com.ntu.oa.util.MsgInfo;

@Service("tianService")
public class TianServiceImpl extends BaseService implements TianService {

	@Resource
	private TianlogMapper tianlogMapper;
	/**
	 * 获取余额
	 */
	@Override
	public ModelResults getBalance(JSONObject json, HttpServletRequest request) {
		ModelResults results = new ModelResults();
		try {
			JSONObject amounts = HttpClientUtil.sendHttpGet(ComConstant.tianbalanceurl);
			results.setData(amounts);
			results.setCode(MsgInfo.a_suc_code);
			results.setMessage(LetterInfo.a_suc_codeMsg);
		} catch (Exception e) {
			e.printStackTrace();
			results.setCode(MsgInfo.a_error_code);
			results.setMessage(LetterInfo.a_error_codeMsg);
		}
		return results;
	}

	/**
	 * 按日期,接口id获取详细
	 */
	@Override
	public ModelResults getDetil(JSONObject json, HttpServletRequest request) {
		ModelResults results = new ModelResults();
		try {
			Map<String, Object> param = new HashMap<>();
			results = super.getPage(results, json);
			param.put("start", results.getStart());
			param.put("size", results.getPageSize());
			param.put("time", json.get("time"));
			param.put("tianId", json.get("tianId"));
			List<Map<Object, Object>> data = tianlogMapper.getDetilByTime(param);
			results.setData(data);
			results.setCode(MsgInfo.a_suc_code);
			results.setMessage(LetterInfo.a_suc_codeMsg);
		} catch (Exception e) {
			e.printStackTrace();
			results.setCode(MsgInfo.a_error_code);
			results.setMessage(LetterInfo.a_error_codeMsg);
		}
		return results;
	}

}
