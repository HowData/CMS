package com.ntu.oa.bean;

public class Userbasic {
    private Long id;//主键

    private String phone;//手机号

    private String nickName;//昵称

    private String industry;//所属行业

    private String head;//头像src

    private String pass;//密码

    private Integer level;//会员登记

    private Integer flagWechat;//是否绑定微信
    
    private String regTime;//注册时间
    
    private String lastLogTime;//最后一次登录时间

    public String getLastLogTime() {
		return lastLogTime;
	}

	public void setLastLogTime(String lastLogTime) {
		this.lastLogTime = lastLogTime;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getFlagWechat() {
		return flagWechat;
	}

	public void setFlagWechat(Integer flagWechat) {
		this.flagWechat = flagWechat;
	}

	public String getRegTime() {
		return regTime;
	}

	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getNickname() {
        return nickName;
    }

    public void setNickname(String nickname) {
        this.nickName = nickname == null ? null : nickname.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head == null ? null : head.trim();
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass == null ? null : pass.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getFlagwechat() {
        return flagWechat;
    }

    public void setFlagwechat(Integer flagwechat) {
        this.flagWechat = flagwechat;
    }
}