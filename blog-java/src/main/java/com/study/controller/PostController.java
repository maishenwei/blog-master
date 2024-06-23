package com.study.controller;

import com.study.pojo.Post;
import com.study.pojo.Result;
import com.study.pojo.User;
import com.study.service.PostService;
import com.study.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/list")
    public Result list(){
        List<Post> posts = postService.getAll();
        if(posts != null && !posts.isEmpty()){
            return Result.success(posts);
        }
        return Result.error("暂无博客");
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Post post = postService.getById(id);
        if(post != null){
            return Result.success(post);
        }
        return Result.error("数据不存在");
    }

    @PostMapping("/post")
    public Result postBlog(@RequestBody Post post){
        post.setLunbo((short)1);
        post.setCreateTime(LocalDateTime.now());
        postService.insert(post);
        return Result.success("发布成功");
    }
}
