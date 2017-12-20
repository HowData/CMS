package com.ntu.oa.bean;

/**
 * 消息中心表
 * @author admin
 *
 */
public class Message {
    private Long id;

    private String title;//消息标题

    private String text;//正文

    private Long userId;//用户id

    private Integer flag;//是否已读，1：已读   0：未读

    private String time;//时间
    
    private Userbasic user;//用户
    
    private int delflag;//删除标识

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

	public Userbasic getUser() {
		return user;
	}

	public void setUser(Userbasic user) {
		this.user = user;
	}

	public int getDelflag() {
		return delflag;
	}

	public void setDelflag(int delflag) {
		this.delflag = delflag;
	}
}