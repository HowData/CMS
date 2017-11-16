package com.ntu.oa.dao;

import java.util.Map;

public interface DynamicDao {

	void addDynam(Map<String, Object> map);
	
	void upDynanmic(Map<String, Object> info);
	
	void delDynamic(int id);
}
