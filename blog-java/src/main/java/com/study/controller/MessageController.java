package com.study.controller;

import com.study.pojo.Message;
import com.study.pojo.Post;
import com.study.pojo.Result;
import com.study.pojo.User;
import com.study.service.MessageService;
import com.study.service.PostService;
import com.study.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;


    @GetMapping("/list")
    public Result list(){
        List<Message> messages = messageService.getAll();
        if(messages != null && !messages.isEmpty()){
            return Result.success(messages);
        }
        return Result.error("暂无留言");
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Message message = messageService.getById(id);
        if(message != null){
            return Result.success(message);
        }
        return Result.error("数据不存在");
    }

    @CrossOrigin
    @PostMapping("/post")
    public Result PostMessage(@RequestBody Message message){
        message.setCreateTime(LocalDateTime.now());
        User user = userService.getById(message.getUserId());
        if(user != null){
            message.setName(user.getName());
            message.setImage(user.getImage());
        }
        messageService.insert(message);
        return Result.success();
    }

}
