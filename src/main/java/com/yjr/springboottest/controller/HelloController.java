package com.yjr.springboottest.controller;

import com.yjr.springboottest.entity.Account;
import com.yjr.springboottest.entity.Test;
import com.yjr.springboottest.mapper.AccountMapper;
import com.yjr.springboottest.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    TestMapper testMapper;

    @GetMapping("/")
    public String hello() {
        return "hello world!";
    }

    @GetMapping("/test")
    public List<Test> helloTest() {
        // 驼峰命名法
        return testMapper.selectAll();
    }
}