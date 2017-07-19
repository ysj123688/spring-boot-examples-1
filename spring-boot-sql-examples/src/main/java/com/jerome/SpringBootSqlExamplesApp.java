package com.jerome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring boot启用类
 * Bean装配默认规则是根据Application类所在的包位置从上往下扫描
 *
 * @author jerome_s@qq.com
 */
@SpringBootApplication
public class SpringBootSqlExamplesApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSqlExamplesApp.class, args);
    }

}
