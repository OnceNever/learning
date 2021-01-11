package com.yanglei.mybatis.entity;

import java.sql.Timestamp;

/**
 * @ClassName: User
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2020/7/26 17:13
 * @Version: V1.0
 */
public class User {

    private Integer id;
    private String userName;
    private Timestamp birthday;
    private String sex;
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
