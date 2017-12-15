package com.ntu.oa.util.redisUtils;

import java.util.Set;
import org.springframework.stereotype.Component;

import com.ntu.oa.util.ValidateUtil;

import redis.clients.jedis.Jedis;

@Component
public class RedisEspImpl extends RedisBaseImpl
{
    public static final String Msg_domain = RedisBaseImpl.TKBASE;

    //天时间
    public static final int sec = 604800;

    public void set(String key,String value)
    {
        key = Msg_domain + key;
        jedis.set(key, value);
        jedis.expire(key, sec);
    }

    public String get(String key)
    {
        key = Msg_domain + key;
        return jedis.get(key);
    }

    public void set(String key,String value,int second)
    {
        key = Msg_domain + key;
        jedis.set(key, value);
        jedis.expire(key, second);
    }

    public boolean deleteKey(String key)
    {
        key = Msg_domain + key;
        return jedis.del(key);
    }

    /**
    	 * redis删除前缀的key
    	 * 
    	 * @param key
    	 * @return
    	 */
    public boolean deleteBatchKey(String key)
    {
        key = Msg_domain + key;
        batchDel(key);
        return true;
    }

    private void batchDel(String batchkey)
    {
        Jedis redis = jedisBean.getRedis();
        Set<String> set = redis.keys(batchkey + "*");
        if (ValidateUtil.isNotEmpty(set))
        {
            String[] keys = (String[]) set.toArray(new String[set.size()]);//使用了第二种接口，返回值和参数均为结果  
            redis.del(keys);
        }
    }
}
