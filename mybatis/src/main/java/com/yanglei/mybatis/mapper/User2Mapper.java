package com.yanglei.mybatis.mapper;

import com.yanglei.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName: User2Mapper
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2020/8/1 14:19
 * @Version: V1.0
 */
@Mapper
public interface User2Mapper {

    /**
    * @Description TODO 使用配置文件的方法操作数据库
    * @Date 14:22 2020/8/1
    * @Param [id]
    * @return com.yanglei.mybatis.entity.User
    **/
    public User qryById(Integer id);

    /**
    * @Description TODO
    * @Date 14:26 2020/8/1
    * @Param [user]
    * @return int
    **/
    public int insert(User user);
}
