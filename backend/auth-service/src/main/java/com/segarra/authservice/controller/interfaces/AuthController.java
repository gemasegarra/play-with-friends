package com.segarra.authservice.controller.interfaces;


import com.segarra.authservice.model.Authorization;

public interface AuthController {
    void registerUser(Authorization user);
    void loginUser(Authorization user);

}
