package com.yanglei.mybatis.controller;

import com.yanglei.mybatis.entity.User;
import com.yanglei.mybatis.mapper.User2Mapper;
import com.yanglei.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2020/7/26 17:57
 * @Version: V1.0
 */
@RestController
public class UserController {

    @Autowired(required = false)
    UserMapper userMapper;

    @Autowired(required = false)
    User2Mapper user2Mapper;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        User user = userMapper.queryById(id);
        return user;
    }

    @GetMapping("/user")
    public User insert(User user){
        Timestamp birthday = user.getBirthday();
        userMapper.insert(user);
        return user;
    }

    @GetMapping("/delete/{id}")
    public int deleteById(@PathVariable("id") Integer id){
        userMapper.deleteById(id);
        return id;
    }

    @GetMapping("user2/{id}")
    public User qryById(@PathVariable("id") Integer id){
        User user = user2Mapper.qryById(id);
        return user;
    }

}
