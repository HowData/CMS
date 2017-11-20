package com.ntu.oa.dao;

import java.util.Map;

public interface LogisticsDao {
	
	void addLogis(Map<String, Object> map);
	
	void upLogis(Map<String, Object> info);
	
	void delLogis(Map<String, Object> map);

	String getFile(long id);
}
