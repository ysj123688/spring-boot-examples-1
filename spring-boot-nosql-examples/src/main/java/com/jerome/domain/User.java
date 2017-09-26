package com.jerome.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 用户实体类
 *
 * @author suzhida
 * @since 2017/8/16 23:11
 */
@Document(collection = "test_user")
@Data
@Slf4j
public class User {

    // 如果Id没有设置值，默认使用mongodb的ObjectId入库
    @Id
    private String id;

    private String name;

    private int age;

    private int i;

    @CreatedDate
    private Date createdAt;

    // 自动赋值更新时间
    @LastModifiedDate
    private Date updatedAt;

    // 自动实现乐观锁
    @Version
    private Long version;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
