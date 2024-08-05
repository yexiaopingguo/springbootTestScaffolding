package com.yjr.springboottest.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountOneToManyCommentVo {

    private Integer id;
    private String email;
    private String username;
    private List<CommentVo> commentVoList;

}
