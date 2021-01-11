package com.yanglei.restfulcrud.config;

import com.yanglei.restfulcrud.interceptor.loginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

/**
 * @ClassName: WebMvcConfigurer
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2020/6/27 17:01
 * @Version: V1.0
 */
@Configuration
public class WebMvcConfigurer implements org.springframework.web.servlet.config.annotation.WebMvcConfigurer {

    /**
    * @Description TODO springboot2.x版本需要配置静态资源路径，否则无法访问
    * @Date 17:22 2020/6/27
    * @Param [registry]
    * @return void
    **/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    /**
    * @Description TODO 拦截器，拦截除登录之外的任意请求
    * @Date 15:41 2020/7/5
    * @Param [registry]
    * @return void
    **/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new loginHandlerInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/index.html","/","/user/login","/static/**");
    }

    /**
    * @Description TODO 视图解析器
    * @Date 15:21 2020/7/5
    * @Param [registry]
    * @return void
    **/
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

}
