package com.study.mapper;

import com.study.pojo.Message;
import com.study.pojo.Post;
import com.study.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostMapper {
    @Select("select * from blog.blog_post where id=#{id}")
    Post getById(Integer id);

    @Select("select * from blog.blog_post")
    List<Post> getAll();

    void insert(Post post);
}