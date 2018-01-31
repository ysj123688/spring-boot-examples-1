package com.jerome;

import com.jerome.rabbitmq.output.UpdateEventSinkSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.IntegrationComponentScan;

@SpringBootApplication
@EnableBinding({UpdateEventSinkSource.class})
@IntegrationComponentScan
public class SpringCloudStreamApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStreamApp.class, args);
    }

}
