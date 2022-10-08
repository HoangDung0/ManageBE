package com.example.capstoneprojectbe.dto;

import javax.persistence.Column;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private String userID;

    private String userName;

    private String password;

    private String fullName;

    private String phoneNumber;

    private String sex;

    private String dayOfBirth;

    private String address;

    private String email;

    private String roleID;

    private String storeID;

    private boolean status;
}
