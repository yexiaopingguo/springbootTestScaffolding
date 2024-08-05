package com.yjr.springboottest.controller;

import com.yjr.springboottest.entity.Account;
import com.yjr.springboottest.entity.Test;
import com.yjr.springboottest.entity.vo.AccountVo;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RequestMapping("/receive")
@RestController
public class ReceviceController {

    // Restful 风格接收参数
    @GetMapping("/{id}")
    public String getExample1(@PathVariable("id") Long id) {
        return "传入的参数为: " + id;
    }

    // Get 接收参数
    @GetMapping("/get")
    public String getExample2(@RequestParam Long id,
                              @RequestParam String Name) {
        // 如果没有添加 @RequestParam 参数，则会自动映射选择，添加了就必须一一对应，否则报错
        return "传入的 id 参数为: " + id + ", 传入的 Name 参数为: " + Name;
    }

    // Post 接收参数
    @PostMapping("/post")
    public String postExample1(@RequestParam String var1,
                       @RequestParam String var2){
        // x-www-form-urlencoded
        return "变量1: " + var1 + ", 变量2: " + var2;
    }

    // List
    @PostMapping("/list")
    public List<String> postExample2(@RequestParam List<String> names){
        // x-www-form-urlencoded
        // Param1 - names: nameXxx1
        // Param2 - names: nameXxx2
        return names;
    }

    @PostMapping("/list2")
    public int postExample22(@RequestBody List<String> names){
        // raw: json
        // example: ["1", "2"]
        return names.size();
    }

    // Map
    @PostMapping("/map")
    public String postExample3(@RequestParam Map<String, Object> map){
        // x-www-form-urlencoded
        return "name1: " + map.get("name1") + ", name2: " + map.get("name2");
    }

    // 实体类
    @PostMapping("/entity")
    public String postExample4(AccountVo account){
        // x-www-form-urlencoded
        return "email: " + account.getEmail() + ", userName: " + account.getUsername();
    }

    // Json
    @PostMapping("/json")
    public String postExample5(@RequestBody AccountVo account){
        // row: json的形式接收
        return "email: " + account.getEmail() + ", userName: " + account.getUsername();
    }
}
