package com.example.petwear.controller;

import com.example.petwear.pojo.dto.UserLoginDto;
import com.example.petwear.pojo.model.User;
import com.example.petwear.service.Impl.UserServiceImpl;
import com.example.petwear.utils.Result;
import com.example.petwear.utils.ResultGenerator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author qiu
 */
@RestController
@RequestMapping
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("all")
    public List<User> selUserList() {
        return userService.selUserList();
    }

    @PostMapping("login")
    public Result<Object> userLogin(int phone, String password) {
        Result<Object> result = new Result<>();
        UserLoginDto user = userService.userLogin(phone, password);
        if (user != null) {
            result = ResultGenerator.genSuccessResult("登录成功", user);
        } else {
            result.setCode(500);
            result.setMsg("登录失败");
        }
        return result;
    }

    @PostMapping("register")
    public Result<Object> userRegister(User user) {
        Result<Object> result;
        int i = userService.userRegister(user);
        if (i != 0) {
            result = ResultGenerator.genSuccessResult("注册成功");
        } else {
            result = ResultGenerator.genErrorResult("注册失败");
        }
        return result;
    }

    @GetMapping("{userId}")
    public Result<Object> selUserInfo(@PathVariable int userId, @RequestHeader String token) {
        Result<Object> result;
        User user = userService.selUserInfo(userId, token);
        if (user != null) {
            result = ResultGenerator.genSuccessResult("查询成功", user);
        } else {
            result = ResultGenerator.genErrorResult("查询失败");
        }
        return result;
    }

    @PatchMapping("{userId}")
    public Result<Object> updateUser(User user, @PathVariable int userId, @RequestHeader String token) {
        Result<Object> result;
        user.setUserId(userId);
        int i = userService.updateUser(user, token);
        if (i != 0) {
            result = ResultGenerator.genSuccessResult("更新成功");
        } else {
            result = ResultGenerator.genErrorResult("更新失败");
        }
        return result;
    }

}
