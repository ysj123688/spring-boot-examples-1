package com.jerome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Spring boot启用类
 * Bean装配默认规则是根据Application类所在的包位置从上往下扫描
 *
 * @author jerome_s@qq.com
 */
@SpringBootApplication
@EnableScheduling
public class SpringBootExamplesApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootExamplesApp.class, args);
    }

}
