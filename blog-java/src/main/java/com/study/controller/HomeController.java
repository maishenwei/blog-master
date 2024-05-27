package com.study.controller;

import com.study.pojo.Result;
import com.study.pojo.User;
import com.study.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public Result home(@PathVariable Integer id){
        User user = userService.getById(id);
        if(user != null){
            Map<String, Object> datas = new HashMap<>();
            datas.put("user",user);
            return Result.success(datas);
        }
        return Result.error("账号异常");
    }

}
