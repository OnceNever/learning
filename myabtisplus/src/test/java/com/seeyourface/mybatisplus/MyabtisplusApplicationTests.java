package com.seeyourface.mybatisplus;

import com.seeyourface.mybatisplus.entity.User;
import com.seeyourface.mybatisplus.mapper.UserMapper;
import com.seeyourface.mybatisplus.services.UserServiceImpl;
import com.seeyourface.mybatisplus.services.interfaces.IUserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MyabtisplusApplicationTests {

    @Autowired
    UserServiceImpl userService;

    @Test
    void testSaveOrUpdate(){
        User user = new User();
        user.setId(6L);
        user.setAge(26);
        user.setName("haha");
        user.setEmail("haha@163.com");
        userService.saveOrUpdate(user);
    }

    @Test
    void testSave(){
       User user = new User();
       user.setAge(24);
       user.setName("Coco");
       user.setEmail("coco@163.com");
       userService.save(user);
    }

    @Test
    void contextLoads() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userService.list(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

}
