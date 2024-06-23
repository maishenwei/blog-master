package com.study.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private Integer id; //ID
    private Integer userId; //用户id
    private String name; //用户名字
    private String image; //用户头像
    private String content; //内容
    private LocalDateTime createTime; //创建时间
}
