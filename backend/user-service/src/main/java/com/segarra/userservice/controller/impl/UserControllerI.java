package com.segarra.userservice.controller.impl;

import com.segarra.userservice.controller.dto.UserDTO;
import com.segarra.userservice.controller.interfaces.UserController;
import com.segarra.userservice.model.User;
import com.segarra.userservice.service.impl.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserControllerI implements UserController {

    @Autowired
    private UserServiceI userService;

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public Long createUser(@RequestBody UserDTO user) {
        return userService.createUser(user);
    }

    @Override
    public String updateUser(UserDTO user) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }

    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAll() {
        return userService.findAll();
    }
}
