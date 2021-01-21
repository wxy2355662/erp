package com.mar.erp.base.redis;

import com.sun.corba.se.spi.ior.ObjectKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


@Component
public class  RedisSet {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 把数据添加进入redis数据库
     * @param key
     * @param value
     */
    public void setRedisData(String key,Object value,Integer time){
//        System.out.println(key);
//        System.out.println(value);
        redisTemplate.opsForValue().set(key,value);
        //设置过期时间  TimeUnit.MINUTES 单位
        redisTemplate.expire(key,time,TimeUnit.MINUTES );

    }



    /**
     * 判断redis中key是否存在
     * @param key
     * @return
     */
    public boolean verdictRedisByKey(String key){
        return redisTemplate.hasKey(key);
    }


    /**
     * 根据key获取对应的value值
     * @param key
     * @return
     */
    public Object getRedisValue(String key){
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 根据对应key删除redis里对应数据
     * @param key
     */
    public void deleteRedisByKey(String key){
        redisTemplate.delete(key);
    }

}
