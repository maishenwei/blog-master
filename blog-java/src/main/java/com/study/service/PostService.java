package com.study.service;

import com.study.pojo.Post;
import com.study.pojo.User;

import java.util.List;

public interface PostService {

    Post getById(Integer id);

    List<Post> getAll();

    void delete(List<Integer> ids);
    void update(Post post);

    void insert(Post post);
}
