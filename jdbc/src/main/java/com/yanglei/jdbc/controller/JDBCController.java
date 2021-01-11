package com.yanglei.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: JDBCController
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2020/7/26 14:59
 * @Version: V1.0
 */
@Controller
public class JDBCController {

    @Autowired
    JdbcTemplate template;

    @ResponseBody
    @RequestMapping("/query")
    public Object query(){
        List<Map<String, Object>> mapList = template.queryForList("select * from user");
        return mapList;
    }
}
