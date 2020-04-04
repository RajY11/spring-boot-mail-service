package com.r3tech.springbootmailservice.service;

import com.r3tech.springbootmailservice.model.MailContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;
    public void sendMessage(MailContent message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(message.getEmailId());
        simpleMailMessage.setSubject(message.getSubject());
        simpleMailMessage.setText(message.getContent());

        javaMailSender.send(simpleMailMessage);
    }
}
