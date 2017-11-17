package com.ntu.oa.dao;

import java.util.Map;

public interface LogisticsDao {
	
	void addLogis(Map<String, Object> map);
	
	void upLogis(Map<String, Object> info);
	
	void delLogis(long id);

	String getFile(long id);
}
