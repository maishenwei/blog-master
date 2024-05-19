package com.study.service;

import com.study.pojo.User;

import java.util.List;

public interface UserService {

    User getById(Integer id);

    void delete(List<Integer> ids);
    void update(User user);

    void save(User user);

    User login(User user);
}
