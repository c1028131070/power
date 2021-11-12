package com.spring.springtest.redis;

public class RedisTemplate<T, V> implements RedisOperations {

    private String redisClient;

    private T object1;
    private V object2;

    public RedisTemplate() {
    }

    public RedisTemplate(String redisClient) {
        this.redisClient = redisClient;
    }

    /**
     * 获取redisClient
     * @return redisClient
     */
    public String getRedisClient() {
        return redisClient;
    }
}
