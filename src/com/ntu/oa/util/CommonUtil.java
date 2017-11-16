package com.ntu.oa.util;

import java.util.UUID;

public class CommonUtil
{
	public static String getUUID()
	{
		return UUID.randomUUID().toString();
	}
	
	public static String getSuffix(String fileName)
	{
		return fileName.substring(fileName.indexOf('.'), fileName.length());
	}
	
}
