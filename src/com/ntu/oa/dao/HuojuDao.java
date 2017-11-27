package com.ntu.oa.dao;

import java.util.List;
import java.util.Map;

public interface HuojuDao {
	
	void addHuoju(Map<String, Object> map);
	
	void upHuoju(Map<String, Object> info);
	
	void delHuoju(long id);
	
	List<Map<Object, Object>> getHuoju(Map<String, Object> map) throws Exception;
}
