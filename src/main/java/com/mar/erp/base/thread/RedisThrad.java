package com.mar.erp.base.thread;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mar.erp.base.redis.RedisSet;

public class RedisThrad implements  Runnable {

    public RedisSet redisSet;
    public String ip;
    public Object value;
    public Integer time;

    public RedisThrad(RedisSet redisSet, String ip, Object value,Integer time) {
        this.redisSet = redisSet;
        this.ip = ip;
        this.value = value;
        this.time=time;
    }

    @Override
    public void run() {
        redisSet.setRedisData(ip,value,time);
    }
}
