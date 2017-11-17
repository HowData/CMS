package com.ntu.oa.service.impl;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.ntu.oa.bean.ModelResults;
import com.ntu.oa.dao.AdminDao;
import com.ntu.oa.service.AdminService;
import com.ntu.oa.util.MD5Util;
import com.ntu.oa.util.msgUtil.LetterInfo;
import com.ntu.oa.util.msgUtil.MsgInfo;


@Service("loginService")
public class LoginServiceImpl  implements AdminService {

	@Resource
	private AdminDao adminDao;

	@Override
	public ModelResults login(JSONObject json, HttpServletRequest request) {
		ModelResults results = new ModelResults();
		Map<String, Object> admin = adminDao.getAdmin(json.getString("account"));
		String pass = MD5Util.GetMD5Code(json.getString("pass"));
		if(admin==null){
			results.setCode(MsgInfo.a_error_code);
			results.setMessage(LetterInfo.NO_USER_EXIST);
		}else if(pass.equals(admin.get("pass"))){
			results.setCode(MsgInfo.a_suc_code);
			results.setMessage(LetterInfo.a_suc_codeMsg);
		}else{
			results.setCode(MsgInfo.a_error_code);
			results.setMessage(LetterInfo.NO_USER_PASSWORD);
		}
		return results;
}
}
