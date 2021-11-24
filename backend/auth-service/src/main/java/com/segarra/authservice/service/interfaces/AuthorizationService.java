package com.segarra.authservice.service.interfaces;

import com.segarra.authservice.model.Authorization;

public interface AuthorizationService {

    public void registerUser(Authorization user);
    public void loginUser(Authorization user);
}
