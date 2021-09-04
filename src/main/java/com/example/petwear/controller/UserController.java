package com.example.petwear.controller;

import com.example.petwear.mapper.UserMapper;
import com.example.petwear.pojo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/test")
    public List<User> queryUserList() {
        List<User> users = userMapper.queryUserList();
        return users;
    }
}
