package com.example.capstoneprojectbe.controller;

import com.example.capstoneprojectbe.dto.UserDto;
import com.example.capstoneprojectbe.model.User;
import com.example.capstoneprojectbe.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody UserDto dto) {// lấy dữ liệu tryền vào dto
        if(userService.isExisted(dto.getUserID())){
            return ResponseEntity.badRequest().body("User Id is duplicated");
        }
        // tạo annoation//?
        userService.createUser(dto);
        return ResponseEntity.ok().body("Successful");
    }
    @GetMapping
    private ResponseEntity getAll() {
        List<User> userList = userService.getAll();
        return ResponseEntity.ok().body(userList);
    }

    @PostMapping("/login")
    private ResponseEntity checkLogin(@RequestParam String userID, @RequestParam String password) {
        User user = userService.checkLogin(userID,password);
        if(user == null){
            return ResponseEntity.badRequest().body("Wrong username & password");
        }
        return ResponseEntity.ok().body(user);
    }

    @PutMapping
    private ResponseEntity update(@RequestBody UserDto dto) {
        userService.update(dto);
        return ResponseEntity.ok().body("Successful");
    }

    @PutMapping("/updatepassword")
    private ResponseEntity updatePassword(@RequestBody UserDto dto) {
        userService.updatePassword(dto);
        return ResponseEntity.ok().body("Successful");
    }

    @PutMapping("/updatestore")
    private ResponseEntity updateStore(@RequestBody UserDto dto) {
        userService.updateStore(dto);
        return ResponseEntity.ok().body("Successful");
    }

    @DeleteMapping()
    private ResponseEntity delete(@RequestParam String id) {
        userService.delete(id);
        return ResponseEntity.ok().body("Successful");
    }

    @GetMapping("/get-by-id")
    private ResponseEntity getById(@RequestParam String userID) {
        User user = userService.getUserById(userID);
        return ResponseEntity.ok().body(user);
    }




}
