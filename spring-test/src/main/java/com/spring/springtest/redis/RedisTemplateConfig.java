package com.spring.springtest.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisTemplateConfig {

    @Bean(name = "redisTemplate")
    public RedisTemplate setRedisTemplate() {
        return new StringRedisTemplate("configRedisTemplate");
    }
}
