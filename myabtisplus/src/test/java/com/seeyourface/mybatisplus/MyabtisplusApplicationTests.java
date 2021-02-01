package com.seeyourface.mybatisplus;

import com.seeyourface.mybatisplus.entity.User;
import com.seeyourface.mybatisplus.mapper.UserMapper;
import com.seeyourface.mybatisplus.services.interfaces.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MyabtisplusApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

}
