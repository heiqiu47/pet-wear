package com.example.petwear.controller;

import com.example.petwear.mapper.UserMapper;
import com.example.petwear.pojo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author qiu
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserMapper userMapper;

    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping("/all")
    public List<User> queryUserList() {
        return userMapper.queryUserList();
    }

    @PostMapping("/login")
    public String login(int phone, String password) {
        String s = userMapper.loginByPhone(phone, password);
        if (s == null) {
            s = "登录失败";
        }
        return s;
    }
}
