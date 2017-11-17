package com.ntu.oa.dao;

import java.util.Map;

public interface FinanceDao {
	
	void addFinan(Map<String, Object> map);
	
	void upFinan(Map<String, Object> info);
	
	void delFinan(long id);

	String getFile(long id);
}
