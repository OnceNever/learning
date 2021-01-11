package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ClassName: HelloController
 * @Description: TODO 控制器
 * @Author: Yanglei
 * @Date: 2020/5/28 9:35
 * @Version: V1.0
 */
@RestController
public class HelloController {

    /**@Value一般用来获取配置文件中的某一个属性*/
    @Value("${people.name}")
    private String name;

    @RequestMapping("/hello")
    public String hello(){
        return "hello "+name;
    }
}
