package com.yjr.springboottest.controller.crud;

import com.yjr.springboottest.entity.Account;
import com.yjr.springboottest.entity.vo.AccountVo;
import com.yjr.springboottest.mapper.AccountMapper;
import com.yjr.springboottest.mapper.AccountVoMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/create")
@RestController
public class CreateController {

    @Autowired
    AccountMapper accountMapper;

    @Autowired
    AccountVoMapper accountVoMapper;

    @PostMapping("/entity")
    public int postExample1(Account account){
        // x-www-form-urlencoded
        // 根据栏位名称自动映射，Vo同
        return accountMapper.addNewAccount(account);
    }

    @PostMapping("/entityVo")
    public int postExample1(AccountVo account){
        // x-www-form-urlencoded
        return accountVoMapper.addNewAccountVo(account);
    }
}
