package com.study.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id; //ID
    private String username; //用户名
    private String password; //密码
    private String name; //姓名
    private Short gender; //性别 , 1 男, 2 女
    private String image; //图像url
    private Short level; //等级 , 1 青铜 , 2 白银 , 3 黄金 , 4 铂金 , 5 钻石 6,大师 7最强王者
    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //修改时间
}
