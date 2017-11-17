package com.ntu.oa.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.alibaba.fastjson.JSONObject;
import com.ntu.oa.bean.ModelResults;
import com.ntu.oa.dao.DynamicDao;
import com.ntu.oa.dao.FinanceDao;
import com.ntu.oa.dao.HuojuDao;
import com.ntu.oa.dao.LogisticsDao;
import com.ntu.oa.service.DynamicService;
import com.ntu.oa.util.CommonUtil;
import com.ntu.oa.util.RequestUtil;
import com.ntu.oa.util.LetterInfo;
import com.ntu.oa.util.MsgInfo;

@Service("dynamicService")
public class DynamicServiceImpl implements DynamicService {
	@Value("#{configProperties['FilePath']}")
	private String FilePath;

	@Value("#{configProperties['pathname']}")
	private String pathname;

	@Resource
	private DynamicDao dynamicDao;
	@Resource
	private HuojuDao huojuDao;
	@Resource
	private FinanceDao financeDao;
	@Resource
	private LogisticsDao logisticsDao;

	@Override
	public ModelResults addHuoju(JSONObject json, HttpServletRequest request) {
		ModelResults results = new ModelResults();
		Map<String, Object> info = new HashMap<>();
		try {
			info.put("releaseTime", json.getString("releaseTime"));
			info.put("title", json.getString("title"));
			info.put("url", json.getString("url"));
			huojuDao.addHuoju(info);
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
	public ModelResults addDyc(JSONObject json, HttpServletRequest request) {
		ModelResults results = new ModelResults();
		Map<String, Object> info = new HashMap<>();
		try {
			info.put("releaseTime", json.getString("releaseTime"));
			info.put("title", json.getString("title"));
			info.put("url", json.getString("url"));
			dynamicDao.addDynam(info);
		} catch (Exception e) {
			e.printStackTrace();
			results.setCode(MsgInfo.a_error_code);
			results.setMessage(LetterInfo.a_error_codeMsg);
		}
		return results;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public ModelResults delHuoju(JSONObject json, HttpServletRequest request) {
		ModelResults results = new ModelResults();
		try {
			List<String> idList = (List<String>) json.get("idList");
			for(String ids : idList){
				long id = Long.parseLong(ids);
				huojuDao.delHuoju(id);
			}
			results.setCode(MsgInfo.a_suc_code);
			results.setMessage(LetterInfo.a_suc_codeMsg);	
		} catch (Exception e) {
			e.printStackTrace();
			results.setCode(MsgInfo.a_error_code);
			results.setMessage(LetterInfo.a_error_codeMsg);
		}
		return results;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ModelResults delDyc(JSONObject json, HttpServletRequest request) {
		ModelResults results = new ModelResults();
		try {
			List<String> idList = (List<String>) json.get("idList");
			for(String ids : idList){
				long id = Long.parseLong(ids);
				dynamicDao.delDynamic(id);
			}
			results.setCode(MsgInfo.a_suc_code);
			results.setMessage(LetterInfo.a_suc_codeMsg);
		} catch (Exception e) {
			e.printStackTrace();
			results.setCode(MsgInfo.a_error_code);
			results.setMessage(LetterInfo.a_error_codeMsg);
		}
		return results;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ModelResults delFinance(JSONObject json, HttpServletRequest request) {
		ModelResults results = new ModelResults();
		try {
			List<String> idList = (List<String>) json.get("idList");
			for(String ids : idList){
				long id = Long.parseLong(ids);
				String url = financeDao.getFile(id);
				// String teString =
				// "http://192.168.88.59:8080/image/head17288104470.jpg";
				String fileBuffer[] = url.split("/");
				String fileName = fileBuffer[fileBuffer.length];
				File file = new File(FilePath + fileName);
				// File file = new File("E:/workspace/shanchuceshi.txt");
				// 路径为文件且不为空则进行删除
				if (file.isFile() && file.exists()) {
					file.delete();
				}
				financeDao.delFinan(id);
			}
			results.setCode(MsgInfo.a_suc_code);
			results.setMessage(LetterInfo.a_suc_codeMsg);
		} catch (Exception e) {
			e.printStackTrace();
			results.setCode(MsgInfo.a_error_code);
			results.setMessage(LetterInfo.a_error_codeMsg);
		}
		return results;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ModelResults delLogis(JSONObject json, HttpServletRequest request) {
		ModelResults results = new ModelResults();
		try {
			List<String> idList = (List<String>) json.get("idList");
			for(String ids : idList){
				long id = Long.parseLong(ids);
				String url = logisticsDao.getFile(id);
				// String teString =
				// "http://192.168.88.59:8080/image/head17288104470.jpg";
				String fileBuffer[] = url.split("/");
				String fileName = fileBuffer[fileBuffer.length];
				File file = new File(FilePath + fileName);
				// File file = new File("E:/workspace/shanchuceshi.txt");
				// 路径为文件且不为空则进行删除
				if (file.isFile() && file.exists()) {
					file.delete();
				}
				logisticsDao.delLogis(id);
			}
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
	public ModelResults upHuoju(JSONObject json, HttpServletRequest request) {
		ModelResults results = new ModelResults();
		Map<String, Object> info = new HashMap<>();
		try {
			info.put("id", Long.parseLong(json.getString("id")));
			info.put("releaseTime", json.getString("releaseTime"));
			info.put("title", json.getString("title"));
			info.put("url", json.getString("url"));
			huojuDao.upHuoju(info);
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
	public ModelResults upDyc(JSONObject json, HttpServletRequest request) {
		ModelResults results = new ModelResults();
		Map<String, Object> info = new HashMap<>();
		try {
			info.put("id", Long.parseLong(json.getString("id")));
			info.put("releaseTime", json.getString("releaseTime"));
			info.put("title", json.getString("title"));
			info.put("url", json.getString("url"));
			dynamicDao.upDynanmic(info);
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
	public ModelResults addFinance(MultipartFile[] files, HttpServletRequest res) {
		ModelResults results = new ModelResults();
		try {
			if (files == null || files.length == 0) {
				results.setCode(MsgInfo.a_paramExc_code_null);
				results.setMessage(LetterInfo.a_paramExc_code_errorMsg);
				return results;
			}
			for (MultipartFile mf : files) {
				if (!mf.isEmpty()) {
					String fileName = CommonUtil.getUUID() + CommonUtil.getSuffix(mf.getOriginalFilename());
					File tempFile = new File(FilePath + fileName);
					// 创建文件上传目录
					if (!tempFile.exists()) {
						tempFile.createNewFile();
					}
					mf.transferTo(tempFile);
					// 附件访问路径
					String requPath = RequestUtil.requestURL(res) + pathname + "/" + fileName;
					// 操作数据库
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("imgUrl", requPath);
					map.put("url", res.getParameter("url"));
					map.put("name", res.getParameter("name"));
					map.put("sort", res.getParameter("sort"));
					financeDao.addFinan(map);
				}
			}
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
	public ModelResults upFinance(MultipartFile[] files, HttpServletRequest res) {
		ModelResults results = new ModelResults();
		try {
			Map<String, Object> info = new HashMap<>();
			info.put("url", res.getParameter("url"));
			info.put("name", res.getParameter("name"));
			info.put("sort", res.getParameter("sort"));
			if (files == null || files.length == 0) {
				financeDao.upFinan(info);
			}
			for (MultipartFile mf : files) {
				if (!mf.isEmpty()) {
					String imgUrl = logisticsDao.getFile(Integer.parseInt(res.getParameter("id")));
					String fileBuffer[] = imgUrl.split("/");
					String fileName = fileBuffer[fileBuffer.length];
					File tempFile = new File(FilePath + fileName);
					// 创建文件上传目录
					if (!tempFile.exists()) {
						tempFile.createNewFile();
					}
					mf.transferTo(tempFile);
					financeDao.upFinan(info);
				}
			}
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
	public ModelResults upLogis(MultipartFile[] files, HttpServletRequest res) {
		ModelResults results = new ModelResults();
		try {
			Map<String, Object> info = new HashMap<>();
			info.put("url", res.getParameter("url"));
			info.put("name", res.getParameter("name"));
			info.put("sort", res.getParameter("sort"));
			if (files == null || files.length == 0) {
				logisticsDao.upLogis(info);
			}
			for (MultipartFile mf : files) {
				if (!mf.isEmpty()) {
					String imgUrl = logisticsDao.getFile(Integer.parseInt(res.getParameter("id")));
					String fileBuffer[] = imgUrl.split("/");
					String fileName = fileBuffer[fileBuffer.length];
					File tempFile = new File(FilePath + fileName);
					// 创建文件上传目录
					if (!tempFile.exists()) {
						tempFile.createNewFile();
					}
					mf.transferTo(tempFile);
					logisticsDao.upLogis(info);
				}
			}
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
	public ModelResults addLogis(MultipartFile[] files, HttpServletRequest res) {
		ModelResults results = new ModelResults();
		try {
			if (files == null || files.length == 0) {
				results.setCode(MsgInfo.a_paramExc_code_null);
				results.setMessage(LetterInfo.a_paramExc_code_errorMsg);
				return results;
			}
			for (MultipartFile mf : files) {
				if (!mf.isEmpty()) {
					String fileName = CommonUtil.getUUID() + CommonUtil.getSuffix(mf.getOriginalFilename());
					File tempFile = new File(FilePath + fileName);
					// 创建文件上传目录
					if (!tempFile.exists()) {
						tempFile.createNewFile();
					}
					mf.transferTo(tempFile);
					// 附件访问路径
					String requPath = RequestUtil.requestURL(res) + pathname + "/" + fileName;
					// 操作数据库
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("imgUrl", requPath);
					map.put("url", res.getParameter("url"));
					map.put("name", res.getParameter("name"));
					map.put("sort", res.getParameter("sort"));
					logisticsDao.addLogis(map);
				}
			}
			results.setCode(MsgInfo.a_suc_code);
			results.setMessage(LetterInfo.a_suc_codeMsg);
		} catch (Exception e) {
			e.printStackTrace();
			results.setCode(MsgInfo.a_error_code);
			results.setMessage(LetterInfo.a_error_codeMsg);
		}
		return results;
	}
}
