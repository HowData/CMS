package com.ntu.oa.dao;

import java.util.Map;

public interface HuojuDao {
	
	void addHuoju(Map<String, Object> map);
	
	void upHuoju(Map<String, Object> info);
	
	void delHuoju(int id);
}
