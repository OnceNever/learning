package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.People;
import com.example.demo.mail.IQQEmailService;
import com.example.demo.mail.task.SendMailTask;
import com.example.demo.utils.HttpUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private IQQEmailService service;

    @Autowired
    private People people;

    @Autowired
    ApplicationContext ioc;

    @Autowired
    IQQEmailService emailService;

    @Test
    public void weatherQry() throws Exception{
        String url = "https://wis.qq.com/weather/common?source=xw&weather_type=forecast_1h%7Ctips&province=浙江&city=杭州&county=西湖区";
        String returnStr = HttpUtil.doGet(url);
        Map<String, Object> map = JSON.parseObject(returnStr);
        Object data = map.get("data");
        @SuppressWarnings("unchecked")
        Map<String, Object> forecast = (Map<String, Object>)data;
        Object forecast_1 = forecast.get("forecast_1h");
        @SuppressWarnings("unchecked")
        Map<String, Object> weather = (Map<String, Object>)forecast_1;
        Object lastInfo = weather.get("1");
        @SuppressWarnings("unchecked")
        Map<String, String> result = (Map<String, String>)lastInfo;
        Object tipStr = forecast.get("tips");
        @SuppressWarnings("unchecked")
        Map<String, Object> tipMap = (Map<String, Object>)tipStr;
        Object tipInfo = tipMap.get("observe");
        @SuppressWarnings("unchecked")
        Map<String, Object> tips = (Map<String, Object>)tipInfo;
        StringBuilder contain = new StringBuilder();
        contain.append(result.get("update_time").substring(8,10)+"点气温："+result.get("degree"))
                .append("度, 天气："+result.get("weather")).append("、"+result.get("wind_direction"))
                .append("， 风力："+result.get("wind_power")).append("级。").append(tips.get("1"));
        String tittle = (String)tips.get("0");
        this.sendEmail(tittle,contain.toString());
    }

    public void sendEmail(String tittle, String contain) throws Exception{
        emailService.sendMail("1269123897@qq.com","1269123897@qq.com",tittle,contain);
    }

    @Test
    public void email() throws SchedulerException {
        //1.创建调度器scheduler
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        //2.创建JobDetail实例，并与Job实现类绑定(Job执行内容)
        JobDetail jobDetail = JobBuilder.newJob(SendMailTask.class)
                .usingJobData("sendMessage","发送短信")
                .withIdentity("验证信息").build();
        //3.构建Trigger实例,触发器(告知触发器如何执行对应任务)
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger")
                .usingJobData("tigger","trigger")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0 * 16 * * ?"))
                .build();
        //执行
        scheduler.scheduleJob(jobDetail,cronTrigger);
        System.out.println("----------scheduler start!----------");
        scheduler.start();
        System.out.println("----------scheduler shutdown!----------");
    }

    @Test
    public void contextLoads() throws Exception{
        //测试@ConfigurationProperties注解将配置属性注入实体
        System.out.println(people);
    }

    @Test
    public void testHelloService(){
        //测试容器中是否包含helloService bean组件
        Boolean b = ioc.containsBean("helloService");
        System.out.println(b);
    }

}
