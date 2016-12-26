package com.example.admin.basicproject.data_save.bean;

import java.io.Serializable;

/**
 * Created by admin on 2016/12/26.
 */

public class Userbean implements Serializable{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
