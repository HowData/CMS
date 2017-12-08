package com.ntu.oa.dao;

import java.util.List;
import java.util.Map;

public interface CombasicMapper {
    
    List<Map<Object, Object>> getComLike(Map<String, Object> map) throws Exception;//关键字匹配(公司名)
    
    int getComLikeCount(Map<String, Object> map) throws Exception;//模糊搜索总数(公司名)

	List<Map<Object, Object>> getPersonLike(Map<String, Object> map);//关键字匹配(人名)

	int getPersonLikeCount(Map<String, Object> map);//模糊搜索总数(人名)
}