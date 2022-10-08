package com.example.capstoneprojectbe.service;

import com.example.capstoneprojectbe.dto.UserDto;
import com.example.capstoneprojectbe.model.User;
import com.example.capstoneprojectbe.repository.RoleRepository;
import com.example.capstoneprojectbe.repository.StoreRepository;
import com.example.capstoneprojectbe.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final StoreRepository storeRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, StoreRepository storeRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.storeRepository = storeRepository;
    }

    public boolean isExisted(String id) {
        return userRepository.existsById(id);
    }

    public boolean isFullTimeStaff(String id) {
        return userRepository.isFullTimeStaff(id).getId().equals('3');
    }
    public void createUser(UserDto dto) {
        User user = new User();
        user.setUserID(dto.getUserID());
        user.setUserName(dto.getUserName());
        user.setPassword(dto.getPassword());
//        user.setRoleID(dto.getRoleID());
        user.setFullName(dto.getFullName());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setSex(dto.getSex());
        user.setDayOfBirth(dto.getDayOfBirth());
        user.setAddress(dto.getAddress());
        user.setEmail(dto.getEmail());
        user.setStore(storeRepository.getById(dto.getStoreID()));
        user.setStatus(dto.isStatus());
        user.setRole(roleRepository.getById(dto.getRoleID()));
        userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public List<User> getAllFullTime() {
        return userRepository.isFullTimeStaff();
    }

    public void update(UserDto dto) {
        User user = new User();
        user.setUserID(dto.getUserID());
        user.setUserName(dto.getUserName());
        user.setPassword(dto.getPassword());
//        user.setRoleID(dto.getRoleID());
        user.setFullName(dto.getFullName());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setSex(dto.getSex());
        user.setDayOfBirth(dto.getDayOfBirth());
        user.setAddress(dto.getAddress());
        user.setEmail(dto.getEmail());
        user.setStore(storeRepository.getById(dto.getStoreID()));
        user.setStatus(dto.isStatus());
        user.setRole(roleRepository.getById(dto.getRoleID()));
        userRepository.save(user);
    }

    public void updatePassword(UserDto dto) {
        User user = new User();
        user.setUserID(dto.getUserID());
        user.setUserName(dto.getUserName());
        user.setPassword(dto.getPassword());
//        user.setRoleID(dto.getRoleID());
        user.setFullName(dto.getFullName());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setSex(dto.getSex());
        user.setDayOfBirth(dto.getDayOfBirth());
        user.setAddress(dto.getAddress());
        user.setEmail(dto.getEmail());
        user.setStore(storeRepository.getById(dto.getStoreID()));
        user.setStatus(dto.isStatus());
        user.setRole(roleRepository.getById(dto.getRoleID()));
        userRepository.save(user);
    }

    public void updateStore(UserDto dto) {
        User user = new User();
        user.setUserID(dto.getUserID());
        user.setUserName(dto.getUserName());
        user.setPassword(dto.getPassword());
//        user.setRoleID(dto.getRoleID());
        user.setFullName(dto.getFullName());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setSex(dto.getSex());
        user.setDayOfBirth(dto.getDayOfBirth());
        user.setAddress(dto.getAddress());
        user.setEmail(dto.getEmail());
        user.setStore(storeRepository.getById(dto.getStoreID()));
        user.setStatus(dto.isStatus());
        user.setRole(roleRepository.getById(dto.getRoleID()));
        userRepository.save(user);
    }



    public void delete(String id) {
        userRepository.deleteById(id);
    }

    public User getUserById(String userID) {
        return userRepository.findById(userID).get();
    }

    public User checkLogin(String userID, String password){
        return userRepository.checkLoginUserByUserIdAndPassword(userID,password);
    }


}
