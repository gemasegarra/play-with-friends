package com.segarra.edgeserver.service.interfaces;


import com.segarra.edgeserver.controller.dto.AuthorizationDTO;
import com.segarra.edgeserver.controller.dto.UserAuthDTO;

public interface EdgeService {
    public void registerUser(UserAuthDTO user);
    public void loginUser(AuthorizationDTO user);
}
