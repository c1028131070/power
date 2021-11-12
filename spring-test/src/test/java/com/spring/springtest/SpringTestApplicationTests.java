package com.spring.springtest;

import com.spring.springtest.redis.RedisTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.Resource;

@SpringBootTest
class SpringTestApplicationTests implements ApplicationContextAware {

    @Autowired(required = false)
    private RedisTemplate<String,String> redisTemplate;
/*    @Resource
    private RedisTemplate<String,String> redisTemplate;*/

    private ApplicationContext applicationContext;

    @Test
    void contextLoads() {
    }

    @Test
    public void testConditionalOnMissingBean() {
        System.out.println(redisTemplate.getRedisClient());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
