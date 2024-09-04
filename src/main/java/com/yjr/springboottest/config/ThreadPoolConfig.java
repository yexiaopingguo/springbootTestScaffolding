package com.yjr.springboottest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class ThreadPoolConfig {
    @Bean(name = "threadPoolTaskExecutor")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        // 在这里修改
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 配置核心线程数
        executor.setCorePoolSize(Runtime.getRuntime().availableProcessors() * 8);
        // 配置最大线程数
        executor.setMaxPoolSize(Runtime.getRuntime().availableProcessors() * 16);
        // 配置队列大小
        executor.setQueueCapacity(1000);
        // 配置线程前缀
        executor.setThreadNamePrefix("ThreadPool-");
        // 执行初始化
        executor.initialize();
        return executor;
    }
}
