package com.example.petwear.pojo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    int userId;
    String userName;
    int userPhone;
    String userPassword;
    String userSex;
    String userAvatar;
}
