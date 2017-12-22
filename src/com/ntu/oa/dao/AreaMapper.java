package com.ntu.oa.dao;

import java.util.List;
import java.util.Map;


public interface AreaMapper {

	List<Map<Object, Object>> getProvince(Map<String, Object> map);

	List<Map<Object, Object>> getCity(Map<String, Object> map);

	List<Map<Object, Object>> getDistrict(Map<String, Object> map);
	
	List<Map<Object, Object>> getAreaLike(String word);
	
	Map<Object, Object> getNameById(int parentId);
	
	List<Map<Object, Object>> getAreaByLevel(String level);
	
}