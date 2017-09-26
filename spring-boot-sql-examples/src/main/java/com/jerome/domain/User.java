package com.jerome.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.criteria.CriteriaBuilder;

import lombok.Data;

/**
 * @author suzhida
 * @since 2017/7/11 22:52
 */

// @Entity 指明这是一个和数据库表映射的实体类
@Entity
@NamedQuery(name = "User.withNameAndAgeNamedQuery",
            query = "select u from User u where u.name = ?1 and u.age = ?2")
@Data
public class User {

    // @Id 指明此字段为数据库的主键
    @Id
    // @GeneratedValue 指明主键的生成方式为自增
    @GeneratedValue
    private long id;

    private String name;

    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
