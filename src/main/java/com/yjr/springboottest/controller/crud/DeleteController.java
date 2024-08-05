package com.yjr.springboottest.controller.crud;

import com.yjr.springboottest.entity.Account;
import com.yjr.springboottest.entity.vo.AccountVo;
import com.yjr.springboottest.mapper.AccountVoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/delete")
@RestController
public class DeleteController {

    @Autowired
    AccountVoMapper accountVoMapper;

    @PostMapping("/entityVo")
    public int postExample1(AccountVo account){
        // x-www-form-urlencoded
        return accountVoMapper.deleteAccountVo(account);
    }

}
