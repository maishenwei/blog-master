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
            Integer id = u.getId();
            claims.put("id",id);
            claims.put("username",u.getUsername());
            claims.put("password",u.getPassword());

            String jwt = com.itmai.utils.JwtUtils.generateJwt(claims);

            Map<String, Object> datas = new HashMap<>();
            datas.put("id",u.getId());
            datas.put("token",jwt);
            return Result.success(datas,"登录成功");
        }
        return Result.error("用户名或密码错误");
    }

    @CrossOrigin
    @PostMapping("/register")
    public Result register(@RequestBody User user){
        User u = userService.contains(user);
        if(u == null){
            log.info("用户注册：{}",user);
            u = new User();
            String username = user.getUsername();
            String password = user.getPassword();
            u.setUsername(username);
            u.setPassword(password);
            u.setName("用户"+user.getUsername());
            u.setGender((short)1);
            u.setImage("");
            u.setLevel((short)1);
            u.setCreateTime(LocalDateTime.now());
            u.setUpdateTime(LocalDateTime.now());
            log.info("用户创建：{}",u);
            userService.insert(u);
            return Result.success(u,"注册成功,请确认登录");
        }
        return Result.error("用户名已存在");
    }
}
