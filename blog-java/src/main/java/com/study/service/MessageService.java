package com.study.service;

import com.study.pojo.Message;
import com.study.pojo.Post;

import java.util.List;

public interface MessageService {

    Message getById(Integer id);

    List<Message> getAll();

    void delete(List<Integer> ids);
    void update(Message message);

    void insert(Message message);
}
