package com.ntu.oa.util.redisUtils;

import java.io.FileNotFoundException;
import java.util.Properties;
import org.springframework.stereotype.Component;

import com.ntu.oa.util.PropertyUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author aoc;2017年11月27日
 *
 */
@Component("jedisBean")
public class JedisBean
{
    private JedisPoolConfig config = new JedisPoolConfig();

    private JedisPool pool;

    @SuppressWarnings("unused")
    private Jedis redis;

    public JedisBean()
    {
        super();
        Properties properties = null;
        try
        {
            properties = PropertyUtil.readProperties("prop.properties");
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        String redisIp = properties.getProperty("redisIp");
        String h[] = redisIp.split(":");
        // 控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；  　　
        //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
        config.setMaxActive(1024);
        //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。  
        config.setMaxIdle(200);
        //表示当borrow一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出 　　　 
        config.setMaxWait(1000);
        //表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；  
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);
        pool = new JedisPool(config, h[0], Integer.parseInt(h[1]), 1000, properties.getProperty("redisPassword"));
    }

    public static void main(String[] args)
    {
        new JedisBean().getRedis().set("123", "snowolf");
        System.out.println(new JedisBean().getRedis().get("123"));
    }

    public JedisPool getPool()
    {
        return pool;
    }

    public void setPool(JedisPool pool)
    {
        this.pool = pool;
    }

    public Jedis getRedis()
    {
        Jedis jedis = null;
        int count = 0;
        do
        {
            try
            {
                jedis = this.getPool().getResource();
            }
            catch(Exception e)
            {
                getPool().returnBrokenResource(jedis);
                e.printStackTrace();
            }
            count++;
        }
        while(jedis == null && count < 200);
        return jedis;
    }

    public void setRedis(Jedis redis)
    {
        this.redis = redis;
    }
}
