package com.example.demo.mail.impl;

import com.example.demo.mail.IQQEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

/**
 * @ClassName: QQEmailServiceImpl
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2020/5/28 16:30
 * @Version: V1.0
 */
@Service
public class QQEmailServiceImpl implements IQQEmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendMail(String from, String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);

        try {
            mailSender.send(message);
        } catch (MailException e) {
            e.printStackTrace();
        }
    }
}
