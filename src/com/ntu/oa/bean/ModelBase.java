package com.ntu.oa.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.log4j.Logger;

public class ModelBase
{
    Logger log = Logger.getLogger(ModelBase.class);

    public String code = "200";

    public Object data;

    public Object param;

    public String message = "请求成功";

    public Object getParam()
    {
        return param;
    }

    public void setParam(Object param)
    {
        this.param = param;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public static Map<String, Object> JSON2Map(String jsonStr)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        // 最外层解析
        JSONObject json = JSONObject.parseObject(jsonStr);
        for(Object k : json.keySet())
        {
            Object v = json.get(k);
            // 如果内层还是数组的话，继续解析
            if (v instanceof JSONArray)
            {
                List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
                Iterator<Object> it = ((JSONArray) v).iterator();
                while(it.hasNext())
                {
                    Object json2 = it.next();
                    list.add(JSON2Map(json2.toString()));
                }
                map.put(k.toString(), list);
            }
            else
            {
                map.put(k.toString(), v);
            }
        }
        return map;
    }

    public void printJson(Object o,HttpServletResponse response,String callback)
    {
        String json = "";
        try
        {
            if (o instanceof ModelResults)
            {
                o = (ModelResults) o;
                ((ModelResults) o).redyToPrint();
            }
            response.setContentType("application/json;charset=utf-8");
            response.addHeader("charset", "charset=utf-8");
            response.addHeader("Access-Control-Allow-Origin", "*");
            json = JSONObject.toJSONString(o, SerializerFeature.WriteMapNullValue);
            json = json.replaceAll("null", "\"\"");
            log.info("============================》retjson===" + json);
            response.setContentType("text/html;charset=utf-8");
            if (callback != null && !"".equals(callback))
            {
                response.getWriter().write(callback + "(" + json + ")");
            }
            else
            {
                response.getWriter().write(json);
            }
            response.getWriter().flush();
            response.getWriter().close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
