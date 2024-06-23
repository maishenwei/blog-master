package com.study.mapper;

import com.study.pojo.Message;
import com.study.pojo.Post;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper {
    @Select("select * from blog.blog_message where id=#{id}")
    Message getById(Integer id);

    @Select("select * from blog.blog_message")
    List<Message> getAll();

    void insert(Message message);
}