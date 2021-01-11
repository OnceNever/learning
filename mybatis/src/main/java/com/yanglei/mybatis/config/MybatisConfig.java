package com.yanglei.mybatis.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName: MybatisConfig
 * @Description: TODO 数据库列名和bean不一致时，需要手动开启规则(例如userName user_name)
 * @Author: Yanglei
 * @Date: 2020/7/26 18:52
 * @Version: V1.0
 */
@org.springframework.context.annotation.Configuration
public class MybatisConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return new ConfigurationCustomizer() {
            @Override
            public void customize(Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
