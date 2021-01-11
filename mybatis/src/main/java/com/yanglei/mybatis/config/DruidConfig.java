package com.yanglei.mybatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: DruidConfig
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2020/7/26 17:07
 * @Version: V1.0
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }
    /**
     * @Description TODO 配置Durid的监控 1.配置一个管理后台的servlet
     * @Date 15:58 2020/7/26
     * @Param []
     * @return org.springframework.boot.web.servlet.ServletRegistrationBean
     **/
    @Bean
    public ServletRegistrationBean StatViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String, String> paramsMap = new HashMap<>();
        //添加登录后台时的用户名和密码
        paramsMap.put("loginUsername", "admin");
        paramsMap.put("loginPassword", "123456");
        //配置允许访问，不配置允许全部访问
        paramsMap.put("allow", "");
        //配置拒绝访问
        paramsMap.put("deny", "");
        bean.setInitParameters(paramsMap);
        return bean;
    }


    /**
     * @Description TODO 2.配置一个web监控的Filter
     * @Date 16:11 2020/7/26
     * @Param []
     * @return org.springframework.boot.web.servlet.FilterRegistrationBean
     **/
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String, String> paramsMap = new HashMap<>();
        //排除不拦截的请求
        paramsMap.put("exclusions", "*.js, *.css, *,html, /druid/*");
        bean.setInitParameters(paramsMap);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}
