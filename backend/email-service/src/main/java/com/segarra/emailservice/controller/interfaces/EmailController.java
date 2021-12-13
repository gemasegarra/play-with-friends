package com.segarra.emailservice.controller.interfaces;

import com.segarra.emailservice.controller.dto.EmailDTO;
import org.springframework.web.bind.annotation.RequestBody;

public interface EmailController {
    void sendEmail(EmailDTO emailDTO);
}
