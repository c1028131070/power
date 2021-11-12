package com.spring.springtest.redis;

public class StringRedisTemplate extends RedisTemplate<String,String> {

    public StringRedisTemplate(String redisClient) {
        super(redisClient);
    }
}
