package com.study.mapper;

import com.study.bean.specific.Friend;
import com.study.bean.specific.Tag;
import com.study.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    @Select("select * from blog.blog_user where id=#{id}")
    User getById(Integer id);

    @Select("select * from blog.blog_user where username=#{username} and password=#{password}")
    User getByUsernameAndPassword(User user);

    @Select("select * from blog.blog_user where username=#{username}")
    User containsUserByUsername(User user);

    void insert(User user);
}