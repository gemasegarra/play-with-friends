package com.segarra.edgeserver.client;


import com.segarra.edgeserver.controller.dto.AuthorizationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("auth-service")
public interface AuthClient {

    @PostMapping("/register")
    void registerUser(@RequestBody AuthorizationDTO user);

    @PostMapping("/login")
    void loginUser(AuthorizationDTO user);

}