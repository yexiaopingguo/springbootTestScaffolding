package com.yjr.springboottest.controller;

import com.yjr.springboottest.entity.Test;
import com.yjr.springboottest.mapper.TestMapper;
import com.yjr.springboottest.util.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class HelloController {

    @Autowired
    TestMapper testMapper;

    @GetMapping("/")
    public String hello() {
        return "hello world!";
    }

}
