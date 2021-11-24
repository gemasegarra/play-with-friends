package com.segarra.edgeserver.controller.impl;

import com.segarra.edgeserver.classes.User;
import com.segarra.edgeserver.controller.dto.AuthorizationDTO;
import com.segarra.edgeserver.controller.dto.UserAuthDTO;
import com.segarra.edgeserver.controller.interfaces.EdgeController;
import com.segarra.edgeserver.service.impl.EdgeServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-v1")
public class EdgeControllerI implements EdgeController {

    @Autowired
    private EdgeServiceI edgeService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody UserAuthDTO user) {
        edgeService.registerUser(user);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
        public void loginUser(@RequestBody AuthorizationDTO user) {
        edgeService.loginUser(user);
    }
}
