package com.study.service.impl;

import com.study.mapper.UserMapper;
import com.study.pojo.User;
import com.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public User getById(Integer id) {
        return mapper.getById(id);
    }

    @Override
    public void delete(List<Integer> ids) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void insert(User user) {
        mapper.insert(user);
    }

    @Override
    public User login(User user) {
        return mapper.getByUsernameAndPassword(user);
    }

    @Override
    public User contains(User user) {
        return mapper.containsUserByUsername(user);
    }
}
