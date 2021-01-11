package com.example.demo.mail.task;

import com.example.demo.mail.IQQEmailService;
import com.example.demo.mail.impl.QQEmailServiceImpl;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @ClassName: SendMailTask
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2020/5/29 22:04
 * @Version: V1.0
 */
@Component
public class SendMailTask implements Job {

    @Autowired
    private IQQEmailService service;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        service.sendMail("1269123897@qq.com","1269123897@qq.com","测试邮件","测试1");
    }
}
