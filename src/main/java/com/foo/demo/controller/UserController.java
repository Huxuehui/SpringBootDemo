package com.foo.demo.controller;

import com.foo.demo.model.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class UserController {
    @Cacheable(value="user-key")
    @RequestMapping("/getUser")
    public User getUser(){
        User user=new User(111L, "aa@126.com", "aa", "aa123456", "aa", new Date());
        System.out.println("第一次没有缓存");
        return user;
    }
}
