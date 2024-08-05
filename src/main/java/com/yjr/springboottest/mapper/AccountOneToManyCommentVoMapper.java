package com.yjr.springboottest.mapper;

import com.yjr.springboottest.entity.vo.AccountOneToManyCommentVo;

import java.util.List;

public interface AccountOneToManyCommentVoMapper {

    List<AccountOneToManyCommentVo> queryCommentList(int id);

}
