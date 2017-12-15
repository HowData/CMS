package com.ntu.oa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil
{
    private static Properties loadProperties(String resources) throws FileNotFoundException
    {
        // 使用InputStream得到一个资源文件
        InputStream inputstream = new FileInputStream(resources);
        // new 一个Properties
        Properties properties = new Properties();
        try
        {
            // 加载配置文件
            properties.load(inputstream);
            return properties;
        }
        catch(IOException e)
        {
            throw new RuntimeException(e);
        }
        finally
        {
            try
            {
                inputstream.close();
            }
            catch(IOException e)
            {
                throw new RuntimeException(e);
            }
        }
    }

    public static Properties readProperties(String propertiesFile) throws FileNotFoundException
    {
        String resources = PropertyUtil.class.getClassLoader().getResource(propertiesFile).getPath();
        Properties properties = loadProperties(resources);
        return properties;
    }
}
