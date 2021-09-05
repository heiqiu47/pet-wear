package com.example.petwear.service;

import com.example.petwear.pojo.dto.UserLoginDto;
import com.example.petwear.pojo.model.User;

import java.util.List;

/**
 * @author qiu
 */
public interface UserService {

    List<User> selUserList();

    UserLoginDto userLogin(int phone, String password);

    int userRegister(User user);

    User selUserInfo(int id, String token);

    int updateUser(User user, String token);

}
