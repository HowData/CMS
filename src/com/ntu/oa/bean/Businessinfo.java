package com.ntu.oa.bean;
/**
 * 业务信息表
 * @author aoc
 *
 */
public class Businessinfo {
    private Long id;

    private String linkPerson;//联系人

    private String linkTel;//联系电话

    private String linkAddress;//联系地址

    private String sendProperty;//运输性质

    private String sendType;//运输方式

    private Long comId;//公司id

    private String name;//公司名字
    
    private String desc;//线路描述
    
    private Long localId;//本地数据库的企业唯一标识
    
    private String upTime;//更新时间


	public Long getLocalId() {
		return localId;
	}

	public void setLocalId(Long localId) {
		this.localId = localId;
	}

	public String getUpTime() {
		return upTime;
	}

	public void setUpTime(String upTime) {
		this.upTime = upTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLinkPerson() {
		return linkPerson;
	}

	public void setLinkPerson(String linkPerson) {
		this.linkPerson = linkPerson;
	}

	public String getLinkTel() {
		return linkTel;
	}

	public void setLinkTel(String linkTel) {
		this.linkTel = linkTel;
	}

	public String getLinkAddress() {
		return linkAddress;
	}

	public void setLinkAddress(String linkAddress) {
		this.linkAddress = linkAddress;
	}

	public String getSendProperty() {
		return sendProperty;
	}

	public void setSendProperty(String sendProperty) {
		this.sendProperty = sendProperty;
	}

	public String getSendType() {
		return sendType;
	}

	public void setSendType(String sendType) {
		this.sendType = sendType;
	}

	public Long getComId() {
		return comId;
	}

	public void setComId(Long comId) {
		this.comId = comId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}