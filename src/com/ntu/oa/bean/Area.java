package com.ntu.oa.bean;

public class Area {

	private int id;//表主键
	
	private String code;//地区代码
	
	private String name;//名称
	
	private String nameEn;//英文名称
	
	private String certerlong;//经度
	
	private String certerlat;//纬度
	
	private String parentId;//上级id
	
	private String level;//级别
	
	private String order;//排序级别

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getCerterlong() {
		return certerlong;
	}

	public void setCerterlong(String certerlong) {
		this.certerlong = certerlong;
	}

	public String getCerterlat() {
		return certerlat;
	}

	public void setCerterlat(String certerlat) {
		this.certerlat = certerlat;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
	
	
}
