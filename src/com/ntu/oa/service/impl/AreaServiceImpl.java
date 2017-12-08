package com.ntu.oa.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ntu.oa.bean.ModelResults;
import com.ntu.oa.dao.AreaMapper;
import com.ntu.oa.service.AreaService;
import com.ntu.oa.util.LetterInfo;
import com.ntu.oa.util.MsgInfo;

@Service("AreaSercice")
public class AreaServiceImpl extends BaseService implements AreaService {

	
	@Resource
	private AreaMapper areaMapper;
//	@Autowired
//	private RedisEspImpl redisEspImpl;
	

	/**
	 * 获取省份
	 */
	@Override
	public ModelResults getProvince(JSONObject json, HttpServletRequest request) {
		ModelResults results = new ModelResults();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			String word = json.getString("word");
			map.put("word", word);
			List<Map<Object, Object>> data = areaMapper.getProvince(map);
			results.setData(data);
	        results.setCode(MsgInfo.a_suc_code);
			results.setMessage(LetterInfo.a_suc_codeMsg);
		}catch (Exception e) {
			e.printStackTrace();
			results.setCode(MsgInfo.a_error_code);
			results.setMessage(LetterInfo.a_error_codeMsg);
		}
		return results;
	}
	
	/**
	 * 获取市名
	 */
	@Override
	public ModelResults getCity(JSONObject json, HttpServletRequest request) {
		ModelResults results = new ModelResults();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			String word = json.getString("word");
			String pid = json.getString("pid");
			map.put("word", word);
			map.put("pid", pid);
			List<Map<Object, Object>> data = areaMapper.getCity(map);
			results.setData(data);
	        results.setCode(MsgInfo.a_suc_code);
			results.setMessage(LetterInfo.a_suc_codeMsg);
		}catch (Exception e) {
			e.printStackTrace();
			results.setCode(MsgInfo.a_error_code);
			results.setMessage(LetterInfo.a_error_codeMsg);
		}
		return results;
	}
	
	/**
	 * 获取区名
	 */
	@Override
	public ModelResults getDistrict(JSONObject json, HttpServletRequest request) {
		ModelResults results = new ModelResults();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			String word = json.getString("word");
			String cid = json.getString("cid");
			map.put("word", word);
			map.put("cid", cid);
			List<Map<Object, Object>> data = areaMapper.getDistrict(map);
			results.setData(data);
	        results.setCode(MsgInfo.a_suc_code);
			results.setMessage(LetterInfo.a_suc_codeMsg);
		}catch (Exception e) {
			e.printStackTrace();
			results.setCode(MsgInfo.a_error_code);
			results.setMessage(LetterInfo.a_error_codeMsg);
		}
		return results;
	}


}
