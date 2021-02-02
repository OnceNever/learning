package com.seeyourface.mybatisplus.controller;

import com.seeyourface.mybatisplus.entity.User;
import com.seeyourface.mybatisplus.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2021/2/2 10:53
 * @Version: V1.0
 */
@Controller
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/user")
    public String listUser(Model m){
        List<User> userList = userService.list(null);
        m.addAttribute("users", userList);
        return "userList";
    }
}
