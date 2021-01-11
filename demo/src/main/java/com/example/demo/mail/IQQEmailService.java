package com.example.demo.mail;

import org.springframework.stereotype.Service;

/**
 * @ClassName: IQQEmailService
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2020/5/28 16:27
 * @Version: V1.0
 */
public interface IQQEmailService {

    /**
    * @Description TODO
    * @Date 21:28 2020/5/29
    * @Param [from, to, subject, content]
    * @return void
    **/
    public void sendMail(String from, String to, String subject, String content);
}
