package com.yjr.springboottest.controller.crud;

import com.yjr.springboottest.entity.Account;
import com.yjr.springboottest.entity.vo.AccountVo;
import com.yjr.springboottest.mapper.AccountVoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/update")
@RestController
public class UpdateController {

    @Autowired
    AccountVoMapper accountVoMapper;

    @PostMapping("/entityVo")
    public int postExample1(AccountVo accountVo){
        // x-www-form-urlencoded
        // 根据栏位名称自动映射，Vo同
        return accountVoMapper.updateAccount(accountVo);
    }

}
