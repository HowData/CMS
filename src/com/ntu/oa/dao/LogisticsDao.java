package com.ntu.oa.dao;

import java.util.List;
import java.util.Map;

public interface LogisticsDao {
	
	void addLogis(Map<String, Object> map);
	
	void upLogis(Map<String, Object> info);
	
	void delLogis(Map<String, Object> map);

	String getFile(long id);
	
	List<Map<Object, Object>> getService(Map<String, Object> map) throws Exception;
}
