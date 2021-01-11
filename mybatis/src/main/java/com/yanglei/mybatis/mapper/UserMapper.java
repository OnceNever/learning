package com.yanglei.mybatis.mapper;

import com.yanglei.mybatis.entity.User;
import org.apache.ibatis.annotations.*;

/**
 * @ClassName: UserMapper
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2020/7/26 17:46
 * @Version: V1.0
 */
//@Mapper
public interface UserMapper {

    @Select("select * from user where id=#{id}")
    public User queryById(Integer id);

    @Delete("delete from user where id=#{id}")
    public int deleteById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into user(userName, birthday, sex, address) values(#{userName}, #{birthday}, #{sex}, #{address})")
    public int insert(User user);

    @Update("update user set userName=#{userName}, birthday=#{birthday}, sex=#{sex}, address=#{address} where id=#{id}")
    public int update(User user);
}
