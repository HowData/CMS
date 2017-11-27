package com.ntu.oa.dao;

import java.util.List;
import java.util.Map;

public interface DynamicDao {

	void addDynam(Map<String, Object> map);
	
	void upDynanmic(Map<String, Object> info);
	
	void delDynamic(long id);
	
	List<Map<Object, Object>> getIndustry(Map<String, Object> map) throws Exception;
}
