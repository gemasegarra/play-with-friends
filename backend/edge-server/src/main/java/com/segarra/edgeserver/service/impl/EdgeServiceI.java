package com.segarra.edgeserver.service.impl;

import com.segarra.edgeserver.classes.User;
import com.segarra.edgeserver.client.AuthClient;
import com.segarra.edgeserver.client.UserClient;
import com.segarra.edgeserver.controller.dto.AuthorizationDTO;
import com.segarra.edgeserver.controller.dto.UserAuthDTO;
import com.segarra.edgeserver.service.interfaces.EdgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class EdgeServiceI implements EdgeService {

    @Autowired
    private AuthClient authClient;

    @Autowired
    private UserClient userClient;

    @Override
    public void registerUser(UserAuthDTO user) {
        UserAuthDTO newUser = new UserAuthDTO (user.getUsername(), user.getEmail(), user.getPassword());
        Long id = userClient.createUser(newUser);
        AuthorizationDTO newAuth = new AuthorizationDTO(id, user.getPassword());
        authClient.registerUser(newAuth);
    }

    @Override
    public void loginUser(AuthorizationDTO user) {

        authClient.loginUser(user);

    }
}
