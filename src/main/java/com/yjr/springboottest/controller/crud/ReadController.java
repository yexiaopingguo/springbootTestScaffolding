package com.yjr.springboottest.controller.crud;

import com.alibaba.fastjson2.JSON;
import com.yjr.springboottest.entity.Account;
import com.yjr.springboottest.entity.vo.AccountOneToManyCommentVo;
import com.yjr.springboottest.entity.vo.AccountVo;
import com.yjr.springboottest.mapper.AccountMapper;
import com.yjr.springboottest.mapper.AccountOneToManyCommentVoMapper;
import com.yjr.springboottest.mapper.AccountVoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/read")
@RestController
public class ReadController {

    @Autowired
    AccountMapper accountMapper;

    @Autowired
    AccountVoMapper accountVoMapper;

    @Autowired
    AccountOneToManyCommentVoMapper accountOneToManyCommentVoMapper;

    // MyBatis Plus 自带函数查询
    @GetMapping("/getAccount")
    public Account getAccount() {
        return accountMapper.selectById(1);
    }

    // MyBatis Plus 自定义 xml 文件查询
    @GetMapping("/getAccountByUsername")
    public String getAccountByUsername(@RequestParam String name) {
        Account account = accountMapper.findByUsername(name);
        return accountMapper.findByUsername(name) == null ? "Not Found": JSON.toJSONString(account);
    }

    // 模糊查询
    @GetMapping("/getAccountByFuzzyQuery")
    public List<Account> getAccountByFuzzyQuery(AccountVo accountVo) {
        return accountVoMapper.getAccountByFuzzyQuery(accountVo);
    }

    // 一对多查询
    @GetMapping("/getOneToMany")
    public List<AccountOneToManyCommentVo> getOneToMany(@RequestParam int id) {
        return accountOneToManyCommentVoMapper.queryCommentList(id);
    }

    // 分页查询
    // 具体参考 Mybatis Plus 官网或者博客: https://www.cnblogs.com/BlueSky2021/articles/17771496.html
}
