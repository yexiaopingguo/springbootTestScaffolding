package com.yjr.springboottest.entity;

import com.alibaba.fastjson2.JSONArray;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("test_table")
public class Test {

    private Integer testColumn1;
    private String testColumn2;

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("nb1"," nb1");
        map.put("nb2"," nb2");

        System.out.println(map.get("nnn"));

    }
}
