package com.segarra.edgeserver.controller.interfaces;

import com.segarra.edgeserver.controller.dto.AuthorizationDTO;
import com.segarra.edgeserver.controller.dto.UserAuthDTO;

public interface EdgeController {
    public void registerUser(UserAuthDTO user);
    public void loginUser(AuthorizationDTO user);
}
