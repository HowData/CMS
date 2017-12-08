package com.ntu.oa.dao;

import java.util.List;
import java.util.Map;


public interface MainrouteMapper {
    
    List<Map<Object, Object>> getRouteByComid(Map<String, Object> map);//获取路线

	void insertMainroute(Map<String, Object> info);

	void deleteMainroute(Map<String, Object> map);
    
}