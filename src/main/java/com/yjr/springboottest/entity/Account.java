package com.yjr.springboottest.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("db_account")
public class Account {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String email;
    private String username;
    private String password;
    private String role;
    private String registerTime;

}
