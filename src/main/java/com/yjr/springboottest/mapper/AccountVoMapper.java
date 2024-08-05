package com.yjr.springboottest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yjr.springboottest.entity.Account;
import com.yjr.springboottest.entity.vo.AccountVo;

import java.util.List;

public interface AccountVoMapper extends BaseMapper<Account> {
    int addNewAccountVo(AccountVo accountVo);

    int updateAccount(AccountVo accountVo);

    int deleteAccountVo(AccountVo accountVo);

    List<Account> getAccountByFuzzyQuery(AccountVo accountVo);
}
