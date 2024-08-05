package com.yjr.springboottest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yjr.springboottest.entity.Account;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper extends BaseMapper<Account> {

    int addNewAccount(Account account);

    Account findByUsername(@Param("username") String username);

}
