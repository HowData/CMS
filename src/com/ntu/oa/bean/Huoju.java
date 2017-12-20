package com.ntu.oa.bean;

/**
 * 火炬动态
 * @author admin
 *
 */
public class Huoju {
    private Long id;

    private String releaseTime;//发布时间

    private String title;//标题

    private String url;//超链接

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}