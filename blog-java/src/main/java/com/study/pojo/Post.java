package com.study.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private Integer id; //ID
    private Integer userid; //useID
    private String title; //标题
    private String tagname; //标签
    private String image; //图片
    private Short lunbo; //
    private String introduce; //介绍
    private String content; //内容
    private LocalDateTime createTime; //创建时间
    private Integer lastBlog; //上一篇Id
    private String lastBlogName; //上一篇标题
    private Integer nextBlog; //下一篇Id
    private String nextBlogName; //下一篇标题
}
