package com.segarra.userservice.service.impl;

import com.segarra.userservice.controller.dto.UserDTO;
import com.segarra.userservice.model.User;
import com.segarra.userservice.repository.UserRepository;
import com.segarra.userservice.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceI implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Long createUser(UserDTO user) {
        Optional<User> optionalUser = userRepository.findByUsername(user.getUsername());
        Optional<User> optionalUserEmail = userRepository.findByEmail(user.getEmail());
        if (optionalUser.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username " + user.getUsername() + " taken!");
        }
        if (optionalUserEmail.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email " + user.getEmail() + " is already in use");
        }
        User createdUser = new User(user.getUsername(), user.getEmail(), user.getPlatform());
        userRepository.save(createdUser);
        return createdUser.getId();
    }

    @Override
    public String updateUser(UserDTO user) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public User findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        return optionalUser.get();
    }

    @Override
    public List<User> findAll() {
        List<User> userList = userRepository.findAll();
        if (userList.isEmpty()) {
            return new ArrayList<>();
        }

        return userList;
    }

}


