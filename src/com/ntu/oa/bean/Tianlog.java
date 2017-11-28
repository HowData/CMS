package com.ntu.oa.bean;
/**
 * 天眼查接口日志
 * @author admin
 *
 */
public class Tianlog {
	private Long id;
	
	private String tianId;//天眼查接口id
	
	private String time;//调用时间
	
	private String result;//调用结果
	
	private Double amount;//接口金额

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTianId() {
		return tianId;
	}

	public void setTianId(String tianId) {
		this.tianId = tianId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	
}
