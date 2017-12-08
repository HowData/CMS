package com.ntu.oa.dao;

import java.util.Map;


public interface BusinessinfoMapper {
    
    Map<Object, Object> getBusinessInfo(Map<String, Object> map);//获取业务信息

	void insertInfo(Map<String, Object> info);

	void updateInfo(Map<String, Object> info);
}