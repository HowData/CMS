package com.ntu.oa.bean;
/**
 * 主要线路表
 * @author aoc
 *
 */
public class Mainroute {
    private Long id;

    private String start;//起始地点

    private String end;//终点

    private Long comId;//公司id
    
    private String name;//公司名称
    
    private int type;//往返1单程2往返 
    
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start == null ? null : start.trim();
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end == null ? null : end.trim();
    }
}