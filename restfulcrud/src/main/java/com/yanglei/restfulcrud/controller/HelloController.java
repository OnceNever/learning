package com.yanglei.restfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @ClassName: HelloController
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2020/6/26 18:36
 * @Version: V1.0
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "hello world!";
    }

    @RequestMapping("/success")
    public String success(Map<String, Object> map){
        map.put("name", "杨磊");
        return "success";
    }

    @RequestMapping("/login")
    public String login(){return "index";}

}
