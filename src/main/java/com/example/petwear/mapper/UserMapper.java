package com.example.petwear.mapper;

import com.example.petwear.pojo.dto.UserLoginDto;
import com.example.petwear.pojo.model.Pet;
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

    /**
     * 获取全部用户数据
     *
     * @return 用户数据
     */
    List<User> selUserList();

    /**
     * 登录
     *
     * @param phone    手机号
     * @param password 密码
     * @return id 用户名
     */
    UserLoginDto userLoginByPhone(@Param("phone") int phone,
                                  @Param("password") String password);

    int userRegister(User user);

    User selUserInfo(int userId);

    int updateUser(User user);



//
//    int deleteUser(int id);

}
