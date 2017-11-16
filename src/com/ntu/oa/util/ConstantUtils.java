package com.ntu.oa.util;

import java.util.Map;

/** Created by Administrator on 15-8-28. */
public class ConstantUtils
{
    public static ConstantUtils obj;

    public Map<String, Object> sysEnvironment;

    public Map<String, Object> whiteList;

    public ConstantUtils()
    {
        obj = this;
    }

    public Map<String, Object> getSysEnvironment()
    {
        return sysEnvironment;
    }

    public void setSysEnvironment(Map<String, Object> sysEnvironment)
    {
        this.sysEnvironment = sysEnvironment;
    }

    public Map<String, Object> getWhiteList()
    {
        return whiteList;
    }

    public void setWhiteList(Map<String, Object> whiteList)
    {
        this.whiteList = whiteList;
    }
}
