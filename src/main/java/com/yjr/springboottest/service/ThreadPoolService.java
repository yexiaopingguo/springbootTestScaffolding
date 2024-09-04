package com.yjr.springboottest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

@Service
public class ThreadPoolService {
    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;
    @Async("threadPoolTaskExecutor")
    public void thread1() {
        System.out.println("test");
    }
}
