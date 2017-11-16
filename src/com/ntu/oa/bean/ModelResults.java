package com.ntu.oa.bean;

import java.io.Serializable;

public class ModelResults extends ModelBase implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Long start;// 记录开始的条数

    private Long end;// 记录结束条数

    private Long total; // 总记录数

    private Long pageNum;// page当前页码

    private Integer pageSize;// pageSize每页的记录条数

    public ModelResults()
    {
    }

    public ModelResults(int pagesize,Long page)
    {
        this.pageSize = pagesize;
        setPageNum(page);
    }

    public Long getStart()
    {
        return start;
    }

    public void setStart(Long start)
    {
        this.start = start;
    }

    public Long getEnd()
    {
        return end;
    }

    public void setEnd(Long end)
    {
        this.end = end;
    }

    public Long getTotal()
    {
        return total;
    }

    public void setTotal(Long total)
    {
        this.total = total;
    }

    public Long getPageNum()
    {
        return pageNum;
    }

    public void setPageNum(Long pageNum)
    {
        if (pageNum != null)
        {
            if (pageNum > 0)
            {
                this.pageNum = pageNum;
            }
            else
            {
                this.pageNum = 1L;
            }
            this.start = (this.pageNum - 1) * this.pageSize;
            this.end = this.pageNum * this.pageSize + 1;
        }
    }

    public Integer getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(Integer pageSize)
    {
        this.pageSize = pageSize;
    }

    protected void redyToPrint()
    {
        this.param = null;
    }
}
