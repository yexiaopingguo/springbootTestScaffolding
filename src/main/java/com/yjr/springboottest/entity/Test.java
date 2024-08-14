package com.yjr.springboottest.entity;

import com.alibaba.fastjson2.JSONArray;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("test_table")
public class Test {

    private Integer testColumn1;
    private String testColumn2;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

    }
}
