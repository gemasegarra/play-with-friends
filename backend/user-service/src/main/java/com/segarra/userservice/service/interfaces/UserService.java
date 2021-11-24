package com.segarra.userservice.service.interfaces;

import com.segarra.userservice.controller.dto.UserDTO;
import com.segarra.userservice.model.User;

import java.util.List;

public interface UserService {
    Long createUser(UserDTO user);
    String updateUser(UserDTO user);
    void deleteUser(Long id);
    User findById(Long id);
    List<User> findAll();
}
