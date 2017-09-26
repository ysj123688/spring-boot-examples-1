package com.jerome;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

/**
 * @author suzhida
 * @since 2017/9/26 15:42
 */
@SpringBootTest
@Slf4j
public class RestTemplateTest {

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void getTest() {
        String url = "http://www.baidu.com";
        String result = restTemplate.getForObject(url, String.class);
        log.info("result = {}", result);
    }

    // TODO postTest
    @Test
    public void postTest() {
        String url = "http://www.baidu.com";
        String result = restTemplate.getForObject(url, String.class);
        log.info("result = {}", result);
    }

}
