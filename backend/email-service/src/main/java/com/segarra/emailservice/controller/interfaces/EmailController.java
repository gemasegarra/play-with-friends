package com.segarra.emailservice.controller.interfaces;

import com.segarra.emailservice.controller.dto.EmailDTO;

public interface EmailController {
    void sendEmail(EmailDTO emailDTO);
}
