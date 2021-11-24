package com.segarra.edgeserver.client;

import com.segarra.edgeserver.classes.User;
import com.segarra.edgeserver.controller.dto.UserAuthDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("user-service")
public interface UserClient {


    @PostMapping("/users")
    Long createUser(@RequestBody UserAuthDTO user);

    @GetMapping("/users/{id}")
    User findById(@PathVariable Long id);

    @GetMapping("/users")
    List<User> findAll();
}