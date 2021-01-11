package com.example.demo.config;

import com.example.demo.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: MyConfig
 * @Description: TODO Configuration指明当前类是一个配置类，替代spring配置文件
 * 在spring配置文件中用<bean><bean/>标签来配置组件
 * @Author: Yanglei
 * @Date: 2020/5/31 10:44
 * @Version: V1.0
 */
@Configuration
public class MyConfig {

    /**
    * @Description TODO 将方法的返回值添加到容器中，容器中这个组件的默认id就是方法名
    * @Date 10:55 2020/5/31
    * @Param []
    * @return com.example.demo.service.HelloService
    **/
    @Bean
    public HelloService helloService(){
        System.out.println("配置类中的@Bean给容器中添加组件成功...");
        return new HelloService();}

}
