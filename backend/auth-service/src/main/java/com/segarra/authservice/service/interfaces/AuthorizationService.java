package com.segarra.authservice.service.interfaces;

import com.segarra.authservice.model.Authorization;

public interface AuthorizationService {

    void registerUser(Authorization user);

    void loginUser(Authorization user);
}
