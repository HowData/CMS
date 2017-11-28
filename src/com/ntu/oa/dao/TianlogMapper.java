package com.ntu.oa.dao;

import java.util.List;
import java.util.Map;

public interface TianlogMapper {

	double getamounts(Map<String, Object> map) throws Exception;//获取总消费
	
	List<Map<Object, Object>> getDetilByTime(Map<String, Object> map) throws Exception;//按条件查询
}
