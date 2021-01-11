package com.example.demo.message.test;

import com.example.demo.message.SendMessage;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @ClassName: SendMessageTest
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2020/5/29 9:34
 * @Version: V1.0
 */
public class SendMessageTest {

    public static void main(String[] args) throws SchedulerException {
       TimeTaskInfo();
    }

    public static void TimeTaskInfo() throws SchedulerException {
        //1.创建调度器scheduler
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        //2.创建JobDetail实例，并与Job实现类绑定(Job执行内容)
        JobDetail jobDetail = JobBuilder.newJob(SendMessage.class)
                .usingJobData("sendMessage","发送短信")
                .withIdentity("验证信息").build();
        //3.构建Trigger实例,触发器(告知触发器如何执行对应任务)
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger")
                .usingJobData("tigger","trigger")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0 * 12 * * ?"))
                .build();
        //执行
        scheduler.scheduleJob(jobDetail,cronTrigger);
        System.out.println("----------scheduler start!----------");
        scheduler.start();
        System.out.println("----------scheduler shutdown!----------");
    }
}
