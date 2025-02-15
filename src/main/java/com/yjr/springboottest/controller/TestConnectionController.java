package com.yjr.springboottest.controller;

import com.github.benmanes.caffeine.cache.Cache;
import com.yjr.springboottest.entity.Account;
import com.yjr.springboottest.entity.Student;
import com.yjr.springboottest.mapper.AccountMapper;
import com.yjr.springboottest.service.CacheService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.Set;

@RequestMapping("/try")
@RestController
public class TestConnectionController {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private StringRedisTemplate template;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private CacheService cacheService;

    @Autowired
    private MongoTemplate mongoTemplate;

    // Test MySQL
    @GetMapping("/mysql")
    public Account testMysql() {
        return accountMapper.selectById(1);
    }

    // Test Redis
    @GetMapping("/redis")
    public void testRedis() {
        template.opsForValue().set("testKey", "testValue");
    }

    // Test MongoDB
    @GetMapping("/mongoDB")
    public void testmongoDB() {
        // 定义一个简单的测试文档
        String collectionName = "student";
        Student student = new Student(1, "1", "2", "3");

        // 插入测试数据
        mongoTemplate.insert(student, collectionName);
    }

    // Test RabbitMQ
    @GetMapping("/rabbitmq")
    public void testRabbitmq() {
        rabbitTemplate.convertAndSend("yyds", "This is a test message");
    }

    // Test Put CaffineCache
    @GetMapping("/setCaffineCache")
    public Integer setCaffineCache() {
        Random random = new Random();
        int randomNumber = random.nextInt(1000);
        cacheService.set("test" + randomNumber, 100);
        return cacheService.get("test");
    }

    // Test Get CaffineCache
    @GetMapping("/getCaffineCache")
    public Set<String> getCaffineCache() {
        return cacheService.getAllKeys();
    }

}
