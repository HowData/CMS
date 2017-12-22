package com.ntu.oa.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ntu.oa.bean.ModelResults;
import com.ntu.oa.dao.AreaMapper;
import com.ntu.oa.service.AreaService;
import com.ntu.oa.util.LetterInfo;
import com.ntu.oa.util.MsgInfo;
import com.ntu.oa.util.redisUtils.RedisEspImpl;

@Service("AreaSercice")
public class AreaServiceImpl extends BaseService implements AreaService {

	
	@Resource
	private AreaMapper areaMapper;
	@Autowired
	private RedisEspImpl redisEspImpl;
	

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

	/**
	 * 关键字获取地名
	 */
	@Override
	public ModelResults getArea(JSONObject json, HttpServletRequest request) {
		ModelResults results = new ModelResults();
		try {
			String word = json.getString("word");
			List<Map<Object, Object>> areas = areaMapper.getAreaLike(word);
			List<Map<Object, Object>> result = new ArrayList<Map<Object, Object>>();
			for(Map<Object, Object> area : areas){
				Map<Object, Object> item = new HashMap<Object, Object>();
				item.put("code", area.get("code"));
				StringBuilder s = new StringBuilder("");
				if("2".equals(area.get("level"))){
					s.append(area.get("name"));
				}else if("3".equals(area.get("level"))){
					Map<Object, Object> pro = areaMapper.getNameById(Integer.parseInt((String) area.get("parent_id")));
					s.append(pro.get("name")).append(area.get("name"));
				}else if("4".equals(area.get("level"))){
					Map<Object, Object> city = areaMapper.getNameById(Integer.parseInt((String) area.get("parent_id")));
					Map<Object, Object> pro = areaMapper.getNameById(Integer.parseInt((String) city.get("parent_id")));
					s.append(pro.get("name")).append(city.get("name")).append(area.get("name"));
				}
				String name = s.toString();
				item.put("area", name);
				result.add(item);
			}
			
			results.setData(result);
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
	 * 获取所有地名（暂时不用）
	 */
	@Override
	public ModelResults getAreaAll(JSONObject json, HttpServletRequest request) {
		ModelResults results = new ModelResults();
		try {
//			List<Map<Object, Object>> pros = areaMapper.getAreaByLevel("2");//所有省份
//			
//			List<Map<Object, Object>> citys = areaMapper.getAreaByLevel("3");
//			for(Map<Object, Object> city : citys){
//				StringBuilder s = new StringBuilder("");
//				Map<Object, Object> pro = areaMapper.getNameById(Integer.parseInt((String) city.get("parent_id")));
//				s.append(pro.get("name")).append(city.get("name"));
//				city.put("name", s.toString());
//			}
//			List<Map<Object, Object>> Districts = areaMapper.getAreaByLevel("3");
//			for(Map<Object, Object> District : citys){
//				StringBuilder s = new StringBuilder("");
//				Map<Object, Object> pro = areaMapper.getNameById(Integer.parseInt((String) city.get("parent_id")));
//				s.append(pro.get("name")).append(city.get("name"));
//				city.put("name", s.toString());
//			}
			
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
