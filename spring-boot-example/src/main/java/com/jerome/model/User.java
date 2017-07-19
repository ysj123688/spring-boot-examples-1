package com.jerome.model;

import lombok.Data;

/**
 * @author suzhida@soundbus.cn
 * @since 2017/7/1 17:31
 */
@Data
public class User {

    private String id;

    private String name;

    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
