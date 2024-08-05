package com.yjr.springboottest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yjr.springboottest.entity.Test;

import java.util.List;

public interface TestMapper extends BaseMapper<Test> {

    List<Test> selectAll();
}
