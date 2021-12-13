package com.segarra.emailservice.service.impl;

import com.segarra.emailservice.controller.dto.EmailDTO;
import com.segarra.emailservice.service.interfaces.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceI implements EmailService {
    @Autowired
    private JavaMailSender emailSender;

    @Override
    public void sendEmail(EmailDTO emailDTO) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        try {
            helper.setText(emailDTO.getText(), true);
            helper.setTo(emailDTO.getTo());
            helper.setSubject(emailDTO.getSubject());
            helper.setFrom(emailDTO.getFrom());
            emailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error sending email", e);
        }
    }
}
