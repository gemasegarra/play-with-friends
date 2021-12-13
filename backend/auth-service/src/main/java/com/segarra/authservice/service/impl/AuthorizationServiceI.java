package com.segarra.authservice.service.impl;

import com.segarra.authservice.model.Authorization;
import com.segarra.authservice.repository.AuthorizationRepository;
import com.segarra.authservice.service.interfaces.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AuthorizationServiceI implements AuthorizationService {

    @Autowired
    private AuthorizationRepository authorizationRepository;

    @Override
    public void registerUser(Authorization user) {
        Optional<Authorization> registeredUser = authorizationRepository.findById(user.getId());
        if (registeredUser.isEmpty()) {
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            Authorization newUser = new Authorization(user.getId(), user.getPassword());
            authorizationRepository.save(newUser);
            return;
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already exists!");
    }

    @Override
    public void loginUser(Authorization user) {
        Optional<Authorization> registeredUser = authorizationRepository.findById(user.getId());
        if (registeredUser.isPresent()) {
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            if (passwordEncoder.matches(user.getPassword(), registeredUser.get().getPassword())) {
                return;
            }
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wrong password");
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found");
    }
}
