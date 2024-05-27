package com.study.service;

import com.study.pojo.User;

import java.util.List;

public interface UserService {

    User getById(Integer id);

    void delete(List<Integer> ids);
    void update(User user);

    void insert(User user);

    User login(User user);

    User contains(User user);
}
