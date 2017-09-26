package com.jerome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

/**
 * Spring boot启用类
 * Bean装配默认规则是根据Application类所在的包位置从上往下扫描
 *
 * @author jerome_s@qq.com
 */
@SpringBootApplication
@EnableMongoAuditing // 使实体类的@LastModifiedDate等生效
public class SpringBootNoSqlExamplesApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootNoSqlExamplesApp.class, args);
    }

}
