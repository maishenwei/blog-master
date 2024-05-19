package com.study.controller;

import com.study.pojo.Result;
import com.study.pojo.User;
import com.study.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        User u = userService.login(user);
        if(u != null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id",user.getId());
            claims.put("username",user.getUsername());
            claims.put("password",user.getPassword());

            String jwt = com.itmai.utils.JwtUtils.generateJwt(claims);
            return Result.success(jwt,"登录成功");
        }
        return Result.error("用户名或密码错误");
    }
}
