package com.xworkz.module.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class OTPUtil {
    @Autowired
     private final JavaMailSender javaMailSender;

    public OTPUtil(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendSimpleMessage(String to,String subject,String text){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("vinayakgh25@gmail.com");
        message.setTo(to);
        message.setText(text);
        message.setSubject(subject);
        javaMailSender.send(message);
    }
}
