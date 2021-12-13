package com.segarra.emailservice.controller.impl;

import com.segarra.emailservice.controller.dto.EmailDTO;
import com.segarra.emailservice.controller.interfaces.EmailController;
import com.segarra.emailservice.service.interfaces.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailControllerI implements EmailController {
    @Autowired
    EmailService emailService;

    @Override
    @PostMapping("/email")
    @ResponseStatus(HttpStatus.OK)
    public void sendEmail(@RequestBody EmailDTO emailDTO) {
        emailService.sendEmail(emailDTO);
    }
}
