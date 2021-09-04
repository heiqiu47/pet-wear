package com.example.petwear.mapper;

import com.example.petwear.pojo.dto.UserInfoDto;
import com.example.petwear.pojo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author qiu
 */
@Mapper
@Repository
public interface UserMapper {

    /** 获取全部用户数据
     * @return 用户数据
     */
    List<User> queryUserList();

    /** 登录
     * @param phone 手机号
     * @param password 密码
     * @return id
     */
    String loginByPhone(@Param("phone") int phone,
              @Param("password") String password);

//    User queryUserById(int id);
//
//    int addUser(User user);
//
//    int updateUser(User user);
//
//    int deleteUser(int id);

}
