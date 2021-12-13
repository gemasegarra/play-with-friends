package com.segarra.edgeserver.client;

import com.segarra.edgeserver.controller.dto.EmailDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("email-service")
public interface EmailClient {
    @PostMapping("/email")
    void sendMail(@RequestBody EmailDTO email);
}
