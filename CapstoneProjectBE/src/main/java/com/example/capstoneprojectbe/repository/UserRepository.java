package com.example.capstoneprojectbe.repository;

import com.example.capstoneprojectbe.model.Role;
import com.example.capstoneprojectbe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("select user from User user  where user.userID = ?1 and user.password = ?2")
    User  checkLoginUserByUserIdAndPassword(String userID, String password);

    @Query("select user.role from User user  where user.userID = ?1")
    Role isFullTimeStaff(String userID);

    @Query("select user from User user  where user.role.id = '3'")
    List<User> isFullTimeStaff();

}
