package com.ntu.oa.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSONObject;
import javazoom.upload.MultipartFormDataRequest;

/** Created by Administrator on 15-9-1. */
public class RequestUtil
{
    /** 将request.getParameter("$")的值转换为Integer型
     * 
     * @param request HttpServletRequest
     * @param name String 待转换参数
     * @return Integer 如果request.getParameter("$")为空则返回空 */
    public static Integer getInteger(HttpServletRequest request,String name)
    {
        Integer param = null;
        if (null != request.getParameter(name) && !"".equals(request.getParameter(name))
        && !"null".equals(request.getParameter(name)))
        {
            param = Integer.valueOf(request.getParameter(name));
        }
        return param;
    }

    /** 将request.getParameter("$")的值转换为Long型
     * 
     * @param request HttpServletRequest
     * @param name String 待转换参数
     * @return Long 如果request.getParameter("$")为空则返回空 */
    public static Long getLong(HttpServletRequest request,String name)
    {
        Long param = null;
        if (null != request.getParameter(name) && !"".equals(request.getParameter(name))
        && !"null".equals(request.getParameter(name)))
        {
            param = Long.valueOf(request.getParameter(name));
        }
        return param;
    }

    /** 将request.getParameter("$")作字符串处理
     * 
     * @param request HttpServletRequest
     * @param name String 待转换参数
     * @return String 如果request.getParameter("$")为空则返回空字符串 */
    public static String getString(HttpServletRequest request,String name)
    {
        if (name == null || name.equals(""))
        {
            return "";
        }
        String param = request.getParameter(name);
        if (param == null)
            return "";
        try
        {
            if (request.getMethod().toLowerCase().equals("get"))
            {
                String beforeTransEncode =
                StringUtil.strIfNull(ConstantUtils.obj.getSysEnvironment().get("beforeTransEncode.get"));
                String afterTransEncode =
                StringUtil.strIfNull(ConstantUtils.obj.getSysEnvironment().get("afterTransEncode.get"));
                if (beforeTransEncode != null && beforeTransEncode.length() > 0)
                {
                    param = new String(request.getParameter(name).trim().getBytes(beforeTransEncode), afterTransEncode);
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return "";
        }
        return param.trim();
    }

    /** 对request.getParameterValues()的处理
     * 
     * @param request HttpServletRequest
     * @param name String
     * @return String[] */
    public static String[] getStringValues(HttpServletRequest request,String name)
    {
        String[] temp = request.getParameterValues(name);
        if (name == null || temp == null || temp.length == 0)
        {
            return null;
        }
        String[] s = new String[temp.length];
        try
        {
            if (request.getMethod().toLowerCase().equals("get"))
            {
                String beforeTransEncode =
                StringUtil.strIfNull(ConstantUtils.obj.getSysEnvironment().get("beforeTransEncode.get"));
                String afterTransEncode =
                StringUtil.strIfNull(ConstantUtils.obj.getSysEnvironment().get("afterTransEncode.get"));
                if (beforeTransEncode != null && beforeTransEncode.length() > 0)
                {
                    for(int i = 0; i < temp.length; i++)
                    {
                        String param = new String(temp[i].getBytes(beforeTransEncode), afterTransEncode);
                        s[i] = param;
                    }
                }
                else
                {
                    s = temp;
                }
            }
            else
            {
                s = temp;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return s;
    }

    /** 获取multipart/form-data类型表单的参数
     * 
     * @param request
     * @param name 参数名
     * @return 参数值 */
    public static Integer multiInteger(MultipartFormDataRequest request,String name)
    {
        Integer param = null;
        if (request.getParameter(name) != null && !(request.getParameter(name).equals(""))
        && !"null".equals(request.getParameter(name)))
        {
            param = Integer.valueOf((request.getParameter(name)));
        }
        return param;
    }

    /** 获取multipart/form-data类型表单的参数
     * 
     * @param request
     * @param name 参数名
     * @return 参数值 */
    public static Long multiLong(MultipartFormDataRequest request,String name)
    {
        Long param = null;
        if (request.getParameter(name) != null && !(request.getParameter(name).equals(""))
        && !"null".equals(request.getParameter(name)))
        {
            param = Long.valueOf((request.getParameter(name)));
        }
        return param;
    }

    /** 获取multipart/form-data类型表单的参数
     * 
     * @param request
     * @param name 参数名
     * @return 参数值 */
    public static String multiString(MultipartFormDataRequest request,String name)
    {
        String param = "";
        if (name == null || name.equals(""))
        {
            return param;
        }
        if (request.getParameter(name) == null)
        {
            return param;
        }
        try
        {
            param = new String(request.getParameter(name).trim().getBytes("iso-8859-1"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return "";
        }
        return param;
    }

    /** 访问指定URL
     * 
     * @param url 指定URL
     * @param postinfo 参数
     * @return 访问结果 */
    public static String sendRequest(String url,Hashtable<String, Object> postinfo)
    {
        String response = "";
        try
        {
            URL urlConnect = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) urlConnect.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            if (postinfo != null && postinfo.size() > 0)
            {
                OutputStream out = urlConnection.getOutputStream();
                Enumeration<String> enu = postinfo.keys();
                StringBuffer sb = new StringBuffer();
                while(enu.hasMoreElements())
                {
                    String key = enu.nextElement().toString();
                    String value = postinfo.get(key).toString();
                    sb.append(key + "=" + value + "&");
                }
                String outs = sb.toString();
                if (outs.endsWith("&"))
                {
                    outs = outs.substring(0, outs.length() - 1);
                }
                out.write(outs.getBytes());
                out.flush();
                out.close();
            }
            InputStream in = urlConnection.getInputStream();
            byte[] array = new byte[1024];
            StringBuffer sb = new StringBuffer();
            int len = in.read(array, 0, array.length);
            while(len > 0)
            {
                sb.append(new String(array, 0, len));
                len = in.read(array, 0, array.length);
            }
            response = sb.toString();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            response = null;
        }
        return response;
    }

    /** 描述:获取 post 请求的 byte[] 数组
     * 
     * <pre> 举例： </pre>
     * 
     * @param request
     * @return
     * @throws IOException */
    public static byte[] getRequestPostBytes(HttpServletRequest request) throws IOException
    {
        int contentLength = request.getContentLength();
        if (contentLength < 0)
        {
            return null;
        }
        byte buffer[] = new byte[contentLength];
        for(int i = 0; i < contentLength;)
        {
            int readlen = request.getInputStream().read(buffer, i, contentLength - i);
            if (readlen == -1)
            {
                break;
            }
            i += readlen;
        }
        return buffer;
    }

    /** 描述:获取 post 请求内容
     * 
     * <pre> 举例： </pre>
     * 
     * @param request
     * @return
     * @throws IOException */
    public static String getRequestPostStr(HttpServletRequest request) throws IOException
    {
        byte buffer[] = getRequestPostBytes(request);
        String charEncoding = request.getCharacterEncoding();
        if (charEncoding == null)
        {
            charEncoding = "UTF-8";
        }
        return new String(buffer, charEncoding);
    }

    public static void replyClient(HttpServletResponse resp,Object obj)
    {
        resp.setContentType("text/xml;charset=UTF-8");
        resp.setHeader("Cache-Control", "no-cache");
        try
        {
            PrintWriter out = resp.getWriter();
            String result = JSONObject.toJSONString(obj);
            out.write(result);
            out.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static Integer getPageNum(HttpServletRequest request,Object inputPageNumName)
    {
        int pageNum = 1;
        if (inputPageNumName == null)
        {
            return new Integer(pageNum);
        }
        String pageNumStr = request.getParameter(StringUtil.strIfNull(inputPageNumName));
        if (pageNumStr != null && !pageNumStr.equals(""))
        {
            pageNum = Integer.parseInt(pageNumStr);
        }
        return new Integer(pageNum);
    }
    
    /**
     * 判断操作系统
     * @return
     */
    public static boolean isWindowsOS() {
        boolean isWindowsOS = false;
        String osName = System.getProperty("os.name");
        if (osName.toLowerCase().indexOf("windows") > -1) {
            isWindowsOS = true;
        }
        return isWindowsOS;
    }
    
    public static String requestURL(HttpServletRequest res)
    {
    	if (isWindowsOS()){
    		InetAddress addr;
        	String ip="";
    		try {
    			addr = InetAddress.getLocalHost();
    			ip=addr.getHostAddress().toString(); //获得本机IP
    		} catch (UnknownHostException e) {
    			e.printStackTrace();
    		}
        	return res.getScheme()+"://"+ip+":"+res.getLocalPort()+"/";
    	}else{
    		String ip = "";
    	    try {
    	        for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
    	            NetworkInterface intf = en.nextElement();
    	            String name = intf.getName();
    	            if (!name.contains("docker") && !name.contains("lo")) {
    	                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
    	                    InetAddress inetAddress = enumIpAddr.nextElement();
    	                    if (!inetAddress.isLoopbackAddress()) {
    	                        String ipaddress = inetAddress.getHostAddress().toString();
    	                        if (!ipaddress.contains("::") && !ipaddress.contains("0:0:") && !ipaddress.contains("fe80")) {
    	                            ip = ipaddress;
    	                            System.out.println(ipaddress);
    	                        }
    	                    }
    	                }
    	            }
    	        }
    	    } catch (SocketException ex) {
    	        System.out.println("获取ip地址异常");
    	        ip = "127.0.0.1";
    	        ex.printStackTrace();
    	    }
    	    System.out.println("IP:"+ip);
    	    return res.getScheme()+"://"+ip+":"+res.getLocalPort()+"/";
    		}
    }
}
