package com.segarra.authservice.controller.impl;

import com.segarra.authservice.model.Authorization;
import com.segarra.authservice.service.impl.AuthorizationServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.segarra.authservice.controller.interfaces.AuthController;

@RestController
public class AuthControllerI implements AuthController {

    @Autowired
    private AuthorizationServiceI authorizationService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody Authorization user) {
        authorizationService.registerUser(user);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public void loginUser(@RequestBody Authorization user) {
        authorizationService.loginUser(user);
    }
}
