package com.yanglei.restfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @ClassName: LoginController
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2020/7/5 14:50
 * @Version: V1.0
 */
@Controller
public class LoginController {
    private final String PASS_WORD = "123456";

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session){
        if(!StringUtils.isEmpty(username) && PASS_WORD.equals(password)){
            session.setAttribute("loginuser", username);
            return "redirect:/main.html";
        }
        map.put("Exception","用户名或密码错误！");
        return "index";
    }
}
