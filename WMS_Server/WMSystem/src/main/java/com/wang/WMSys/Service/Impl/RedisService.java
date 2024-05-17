package com.wang.WMSys.Service.Impl;

import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService<K,V> {

    @Resource
    RedisTemplate<K,V> redisTemplate;


    public void set(K key, V value) {
        redisTemplate.opsForValue().set(key,value);
    }


    public V get(K key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void delete(K key) {
        redisTemplate.delete(key);
    }
    public void expire(K key, long time, TimeUnit unit) {
        redisTemplate.expire(key,time,unit);
    }
}
