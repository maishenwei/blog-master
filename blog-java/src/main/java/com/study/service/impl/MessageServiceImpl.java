package com.study.service.impl;

import com.study.mapper.MessageMapper;
import com.study.pojo.Message;
import com.study.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper mapper;


    @Override
    public Message getById(Integer id) {
       return mapper.getById(id);
    }

    @Override
    public List<Message> getAll() {
        return mapper.getAll();
    }

    @Override
    public void delete(List<Integer> ids) {

    }

    @Override
    public void update(Message message) {

    }

    @Override
    public void insert(Message message) {
        mapper.insert(message);
    }

}
