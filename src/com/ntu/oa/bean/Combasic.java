package com.ntu.oa.bean;
/**
 * 企业基本信息表
 * @author aoc
 *
 */
public class Combasic {
    private Long companyid;//主键

    private String updatetime;//天眼查更新时间

    private String fromtime;//营业开始时间

    private Integer type;//法人类型1公司2人

    private Integer categoryscore;//行业评分

    private Long id;//公司id

    private String regnumber;//注册号

    private Integer percentilescore;//公司评分

    private String regcapital;//注册资金

    private String reginstitute;//登记机关

    private String name;//企业名称

    private String reglocation;//注册地址

    private String industry;//行业

    private String approvedtime;//核准时间

    private String orgapprovedinstitute;//核准机构

    private String orgnumber;//组织机构代码

    private String estiblishtime;//成立时间

    private String regstatus;//经营状态

    private String legalpersonname;//法人

    private String totime;//营业期限结束时间

    private Long legalpersonid;//法人id

    private String actualcapital;//实收注册资金

    private Integer flag;//是否显示

    private String correctcompanyid;//曾用名对现在名id

    private String companyorgtype;//公司类型

    private String base;//省份简称

    private String updatetimes;//天眼查解析时间

    private String creditcode;//统一社会信用代码

    private String sourceflag;//信用链接

    private String phonenumber;//联系电话

    private String businessscope;//经营范围
    
    private String websiteList;//网址
    
    private String upTime;//更新时间

    public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getFromtime() {
		return fromtime;
	}

	public void setFromtime(String fromtime) {
		this.fromtime = fromtime;
	}

	public String getApprovedtime() {
		return approvedtime;
	}

	public void setApprovedtime(String approvedtime) {
		this.approvedtime = approvedtime;
	}

	public String getEstiblishtime() {
		return estiblishtime;
	}

	public void setEstiblishtime(String estiblishtime) {
		this.estiblishtime = estiblishtime;
	}

	public String getTotime() {
		return totime;
	}

	public void setTotime(String totime) {
		this.totime = totime;
	}

	public String getUpdatetimes() {
		return updatetimes;
	}

	public void setUpdatetimes(String updatetimes) {
		this.updatetimes = updatetimes;
	}

	public String getUpTime() {
		return upTime;
	}

	public void setUpTime(String upTime) {
		this.upTime = upTime;
	}

	public String getWebsiteList() {
		return websiteList;
	}

	public void setWebsiteList(String websiteList) {
		this.websiteList = websiteList;
	}

	public Long getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Long companyid) {
        this.companyid = companyid;
    }


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCategoryscore() {
        return categoryscore;
    }

    public void setCategoryscore(Integer categoryscore) {
        this.categoryscore = categoryscore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegnumber() {
        return regnumber;
    }

    public void setRegnumber(String regnumber) {
        this.regnumber = regnumber == null ? null : regnumber.trim();
    }

    public Integer getPercentilescore() {
        return percentilescore;
    }

    public void setPercentilescore(Integer percentilescore) {
        this.percentilescore = percentilescore;
    }

    public String getRegcapital() {
        return regcapital;
    }

    public void setRegcapital(String regcapital) {
        this.regcapital = regcapital == null ? null : regcapital.trim();
    }

    public String getReginstitute() {
        return reginstitute;
    }

    public void setReginstitute(String reginstitute) {
        this.reginstitute = reginstitute == null ? null : reginstitute.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getReglocation() {
        return reglocation;
    }

    public void setReglocation(String reglocation) {
        this.reglocation = reglocation == null ? null : reglocation.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }


    public String getOrgapprovedinstitute() {
        return orgapprovedinstitute;
    }

    public void setOrgapprovedinstitute(String orgapprovedinstitute) {
        this.orgapprovedinstitute = orgapprovedinstitute == null ? null : orgapprovedinstitute.trim();
    }

    public String getOrgnumber() {
        return orgnumber;
    }

    public void setOrgnumber(String orgnumber) {
        this.orgnumber = orgnumber == null ? null : orgnumber.trim();
    }


    public String getRegstatus() {
        return regstatus;
    }

    public void setRegstatus(String regstatus) {
        this.regstatus = regstatus == null ? null : regstatus.trim();
    }

    public String getLegalpersonname() {
        return legalpersonname;
    }

    public void setLegalpersonname(String legalpersonname) {
        this.legalpersonname = legalpersonname == null ? null : legalpersonname.trim();
    }


    public Long getLegalpersonid() {
        return legalpersonid;
    }

    public void setLegalpersonid(Long legalpersonid) {
        this.legalpersonid = legalpersonid;
    }

    public String getActualcapital() {
        return actualcapital;
    }

    public void setActualcapital(String actualcapital) {
        this.actualcapital = actualcapital == null ? null : actualcapital.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getCorrectcompanyid() {
        return correctcompanyid;
    }

    public void setCorrectcompanyid(String correctcompanyid) {
        this.correctcompanyid = correctcompanyid == null ? null : correctcompanyid.trim();
    }

    public String getCompanyorgtype() {
        return companyorgtype;
    }

    public void setCompanyorgtype(String companyorgtype) {
        this.companyorgtype = companyorgtype == null ? null : companyorgtype.trim();
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base == null ? null : base.trim();
    }


    public String getCreditcode() {
        return creditcode;
    }

    public void setCreditcode(String creditcode) {
        this.creditcode = creditcode == null ? null : creditcode.trim();
    }

    public String getSourceflag() {
        return sourceflag;
    }

    public void setSourceflag(String sourceflag) {
        this.sourceflag = sourceflag == null ? null : sourceflag.trim();
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public String getBusinessscope() {
        return businessscope;
    }

    public void setBusinessscope(String businessscope) {
        this.businessscope = businessscope == null ? null : businessscope.trim();
    }
}