package com.segarra.emailservice.service.interfaces;

import com.segarra.emailservice.controller.dto.EmailDTO;

public interface EmailService {
    void sendEmail(EmailDTO emailDTO);
}
