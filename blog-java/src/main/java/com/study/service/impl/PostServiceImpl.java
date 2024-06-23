package com.study.service.impl;

import com.study.mapper.PostMapper;
import com.study.mapper.UserMapper;
import com.study.pojo.Post;
import com.study.pojo.User;
import com.study.service.PostService;
import com.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper mapper;

    @Override
    public Post getById(Integer id) {
        return mapper.getById(id);
    }

    @Override
    public List<Post> getAll() {
        return mapper.getAll();
    }

    @Override
    public void delete(List<Integer> ids) {

    }

    @Override
    public void update(Post post) {

    }

    @Override
    public void insert(Post post) {
        mapper.insert(post);
    }
}
