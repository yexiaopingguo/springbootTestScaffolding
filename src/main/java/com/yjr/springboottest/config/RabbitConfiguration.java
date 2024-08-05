package com.yjr.springboottest.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {
    @Bean
    public Queue testQueue() {
        return new Queue("testQueue", true); // true表示持久化该队列
    }
}
