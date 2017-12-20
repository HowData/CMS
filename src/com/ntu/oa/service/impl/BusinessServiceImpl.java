package com.ntu.oa.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ntu.oa.bean.ModelResults;
import com.ntu.oa.dao.BusinessinfoMapper;
import com.ntu.oa.dao.CombasicMapper;
import com.ntu.oa.dao.MainrouteMapper;
import com.ntu.oa.dao.MessageMapper;
import com.ntu.oa.dao.UserBasicMapper;
import com.ntu.oa.service.BusinessService;
import com.ntu.oa.util.DateUtil;
import com.ntu.oa.util.LetterInfo;
import com.ntu.oa.util.MsgInfo;

@Service("BusinessSercice")
public class BusinessServiceImpl extends BaseService implements BusinessService {

	
	@Resource
	private CombasicMapper combasicMapper;
	@Resource
	private MainrouteMapper mainrouteMapper;
	@Resource
	private BusinessinfoMapper businessinfoMapper;
	@Resource
	private MessageMapper messageMapper;
	@Resource
	private UserBasicMapper userBasicMapper;
	
//	@Autowired
//	private RedisEspImpl redisEspImpl;
	

	/**
	 * 主页搜索
	 */
	@Override
	public ModelResults search(JSONObject json, HttpServletRequest request) {
		ModelResults results = new ModelResults();
		try {
			// 关键字模糊搜索数据库
			Map<String, Object> map = new HashMap<String, Object>();
			results = super.getPage(results, json);
			map.put("start", results.getStart());
			map.put("size", results.getPageSize());
			String word = json.getString("param");
			if (word == null || "".equals(word)) {
				results.setMessage("请输入！");
				return results;
			} else {
				String word1 = "\\" + word;
				map.put("param", word1);
				List<Map<Object, Object>> data = combasicMapper.getComLike(map);
				int total = combasicMapper.getComLikeCount(map);
				long total1 = total;
				results.setTotal(total1);
				results.setData(data);
				results.setCode(MsgInfo.a_error_code);
				results.setMessage(LetterInfo.a_error_codeMsg);
			}
		}catch (Exception e) {
			e.printStackTrace();
			results.setCode(MsgInfo.a_error_code);
			results.setMessage(LetterInfo.a_error_codeMsg);
		}
		return results;
	}

	/**
	 * 人名搜索公司
	 */
	@Override
	public ModelResults searchPerson(JSONObject json, HttpServletRequest request) {
		ModelResults results = new ModelResults();
		try {
			// 关键字模糊搜索数据库
			Map<String, Object> map = new HashMap<String, Object>();
			results = super.getPage(results, json);
			map.put("start", results.getStart());
			map.put("size", results.getPageSize());
			String word = json.getString("param");
			if (word == null || "".equals(word)) {
				results.setMessage("请输入！");
				return results;
			} else {
				String word1 = "\\" + word;
				map.put("param", word1);
				List<Map<Object, Object>> data = combasicMapper.getPersonLike(map);
				int total = combasicMapper.getPersonLikeCount(map);
				long total1 = total;
				results.setTotal(total1);
				results.setData(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
			results.setCode(MsgInfo.a_error_code);
			results.setMessage(LetterInfo.a_error_codeMsg);
		}
		return results;
	}

	/**
	 * 获取业务信息
	 */
	@Override
	public ModelResults getBusinessInfo(JSONObject json, HttpServletRequest request) {
		ModelResults results = new ModelResults();
		try
		{	
			Map<String, Object> map = new HashMap<String, Object>();
		    String localId = json.getString("localId");
			map.put("comid", null);
			map.put("localId", localId);
			List<Map<Object, Object>> routeList = mainrouteMapper.getRouteByComid(map);
			Map<Object, Object> data = businessinfoMapper.getBusinessInfo(map);
			if(data != null){
				data.put("routeList", routeList);
				results.setData(data);
		        results.setCode(MsgInfo.a_suc_code);
				results.setMessage(LetterInfo.a_suc_codeMsg);
			}else{
				results.setData(data);
		        results.setCode(MsgInfo.a_suc_code);
				results.setMessage(LetterInfo.a_suc_codeMsg);
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			results.setCode(MsgInfo.a_error_code);
			results.setMessage(LetterInfo.a_error_codeMsg);
		}
		return results;
	}

	/**
	 * 新增业务信息
	 */
	@Override
	public ModelResults addBusinessInfo(JSONObject json, HttpServletRequest request) {
		ModelResults results = new ModelResults();
		try
		{	
			//关联公司id,名称
			long localId = Long.parseLong(json.getString("localId"));
			String name = json.getString("name");
			
			//业务信息联系人等插入
			Map<String, Object> info = new HashMap<String, Object>();
			String linkPerson = json.getString("linkPerson");
			String linkTel = json.getString("linkTel");
			String linkAddress = json.getString("linkAddress");
			String sendProperty = json.getString("sendProperty");
			String sendType = json.getString("sendType");
			String desc = json.getString("desc");
			info.put("localId", localId);
			info.put("name", name);
			info.put("upTime", DateUtil.date3Str(new Date()));
			info.put("linkPerson", linkPerson);
			info.put("linkTel", linkTel);
			info.put("linkAddress", linkAddress);
			info.put("sendProperty", sendProperty);
			info.put("sendType", sendType);
			info.put("desc", desc);
			businessinfoMapper.insertInfo(info);
			
			//主营路线插入
			Map<String, Object> mainroute = new HashMap<String, Object>();
			String start = json.getString("start");
			String end = json.getString("end");
			int type = Integer.parseInt(json.getString("type"));
			mainroute.put("localId", localId);
			mainroute.put("name", name);
			mainroute.put("upTime", DateUtil.date3Str(new Date()));
			mainroute.put("start", start);
			mainroute.put("end", end);
			mainroute.put("type", type);
			mainrouteMapper.insertMainroute(mainroute);
			
		    results.setCode(MsgInfo.a_suc_code);
			results.setMessage(LetterInfo.a_suc_codeMsg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			results.setCode(MsgInfo.a_error_code);
			results.setMessage(LetterInfo.a_error_codeMsg);
		}
		return results;
	}

	/**
	 * 修改业务信息
	 */
	@Override
	public ModelResults updateBusinessInfo(JSONObject json, HttpServletRequest request) {
		ModelResults results = new ModelResults();
		try {
			// 关联公司id,名称
			long localId = Long.parseLong(json.getString("localId"));
			String name = json.getString("name");

			// 业务信息联系人等修改
			Map<String, Object> info = new HashMap<String, Object>();
			String linkPerson = json.getString("linkPerson");
			String linkTel = json.getString("linkTel");
			String linkAddress = json.getString("linkAddress");
			String sendProperty = json.getString("sendProperty");
			String sendType = json.getString("sendType");
			String desc = json.getString("desc");
			info.put("localId", localId);
			info.put("name", name);
			info.put("upTime", DateUtil.date3Str(new Date()));
			info.put("linkPerson", linkPerson);
			info.put("linkTel", linkTel);
			info.put("linkAddress", linkAddress);
			info.put("sendProperty", sendProperty);
			info.put("sendType", sendType);
			info.put("desc", desc);
			businessinfoMapper.updateInfo(info);
			results.setCode(MsgInfo.a_suc_code);
			results.setMessage(LetterInfo.a_suc_codeMsg);
		} catch (Exception e) {
			e.printStackTrace();
			results.setCode(MsgInfo.a_error_code);
			results.setMessage(LetterInfo.a_error_codeMsg);
		}
		return results;
	}

	@Override
	public ModelResults addMainroute(JSONObject json, HttpServletRequest request) {
		ModelResults results = new ModelResults();
		try
		{	
			//关联公司id,名称
			long localId = Long.parseLong(json.getString("localId"));
			String name = json.getString("name");
			
			//主营路线插入
			Map<String, Object> mainroute = new HashMap<String, Object>();
			String start = json.getString("start");
			String end = json.getString("end");
			int type = Integer.parseInt(json.getString("type"));
			mainroute.put("localId", localId);
			mainroute.put("name", name);
			mainroute.put("upTime", DateUtil.date3Str(new Date()));
			mainroute.put("start", start);
			mainroute.put("end", end);
			mainroute.put("type", type);
			mainrouteMapper.insertMainroute(mainroute);
			
		    results.setCode(MsgInfo.a_suc_code);
			results.setMessage(LetterInfo.a_suc_codeMsg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			results.setCode(MsgInfo.a_error_code);
			results.setMessage(LetterInfo.a_error_codeMsg);
		}
		return results;
	}

	@Override
	public ModelResults deleteMainroute(JSONObject json, HttpServletRequest request) {
		ModelResults results = new ModelResults();
		try
		{	
			Map<String, Object> map = new HashMap<String, Object>();
			//路线id
			long mid = Long.parseLong(json.getString("mid"));
			map.put("mid", mid);
			mainrouteMapper.deleteMainroute(map);
			
		    results.setCode(MsgInfo.a_suc_code);
			results.setMessage(LetterInfo.a_suc_codeMsg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			results.setCode(MsgInfo.a_error_code);
			results.setMessage(LetterInfo.a_error_codeMsg);
		}
		return results;
	}

	/**
	 * 发布消息
	 */
	@Override
	public ModelResults publishMsg(JSONObject json, HttpServletRequest request) {
		ModelResults results = new ModelResults();
		try
		{	
			Map<String, Object> info = new HashMap<String, Object>();
			String title = json.getString("title");
			String text = json.getString("text");
			info.put("title", title);
			info.put("text", text);
			info.put("time", DateUtil.date3Str(new Date()));
			info.put("flag", 0);//是否已读
			info.put("delflag", 1);//删除标识
			
			//获取所有用户
			List<Long> ids = userBasicMapper.getUserId();
			for(long id : ids){
				info.put("userid", id);
				messageMapper.insertMsg(info);
			}
		    results.setCode(MsgInfo.a_suc_code);
			results.setMessage(LetterInfo.a_suc_codeMsg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			results.setCode(MsgInfo.a_error_code);
			results.setMessage(LetterInfo.a_error_codeMsg);
		}
		return results;
	}
}
