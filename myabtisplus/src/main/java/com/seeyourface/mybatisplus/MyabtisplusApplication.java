package com.seeyourface.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.seeyourface.mybatisplus.mapper")
public class MyabtisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyabtisplusApplication.class, args);
    }

}
