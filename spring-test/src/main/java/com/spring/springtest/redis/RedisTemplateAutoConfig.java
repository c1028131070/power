package com.spring.springtest.redis;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(RedisOperations.class)
public class RedisTemplateAutoConfig {

    @Bean
    @ConditionalOnMissingBean(name = "redisTemplate")
    public RedisTemplate<Object, Object> redisTemplate() {
        return new RedisTemplate<Object, Object>("autoConfigRedisTemplate");
    }

    @Bean
    @ConditionalOnMissingBean
    public StringRedisTemplate stringRedisTemplate() {
        StringRedisTemplate template = new StringRedisTemplate("stringRedisTemplate");
        return template;
    }

/*    @Bean
    @ConditionalOnMissingBean(name = "redisTemplate")
    public RedisTemplate redisTemplate() {
        return new RedisTemplate ("autoConfigRedisTemplate");
    }*/
}
