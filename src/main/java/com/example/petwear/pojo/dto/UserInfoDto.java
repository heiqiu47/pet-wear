package com.example.petwear.pojo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDto {
    int userId;
    String userName;
    int userPhone;
    String userPassword;
    int userSex;
    String userAvatar;
}
