package com.example.petwear.service.Impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.example.petwear.mapper.UserMapper;
import com.example.petwear.pojo.dto.UserLoginDto;
import com.example.petwear.pojo.model.User;
import com.example.petwear.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qiu
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> selUserList() {
        return userMapper.selUserList();
    }

    @Override
    public UserLoginDto userLogin(int phone, String password) {
        UserLoginDto user = userMapper.userLoginByPhone(phone, password);
        if (user != null) {
            StpUtil.login(user.getUserId());
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            String tokenValue = tokenInfo.getTokenValue();
            user.setToken(tokenValue);
        }
        return user;
    }

    @Override
    public int userRegister(User user) {
        return userMapper.userRegister(user);
    }

    @Override
    public User selUserInfo(int id, String token) {
        User user = null;
        Object tokenId = StpUtil.getLoginIdByToken(token);
        if (tokenId != null && tokenId.equals(String.valueOf(id))) {
            user = userMapper.selUserInfo(id);
        }
        return user;
    }

    @Override
    public int updateUser(User user, String token) {
        int i = 0;
        Object tokenId = StpUtil.getLoginIdByToken(token);
        if (tokenId != null && tokenId.equals(String.valueOf(user.getUserId()))) {
            i = userMapper.updateUser(user);
            System.out.println(i);
        }
        return i;
    }


}
