package com.example.demo.entity;

/**
 * @ClassName: Dog
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2020/5/30 17:23
 * @Version: V1.0
 */
public class Dog {

    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
