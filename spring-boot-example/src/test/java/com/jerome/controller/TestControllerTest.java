package com.jerome.controller;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author suzhida@soundbus.cn
 * @since 2017/7/19 10:14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
//@Transactional // 确保每次测试后的数据会被回滚
public class TestControllerTest {

    MockMvc mvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Before
    public void setUp() throws JsonProcessingException {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testFind() throws Exception {
        String uri = "/test/find";
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
        int status = result.getResponse().getStatus();
        String content = result.getResponse().getContentAsString();

        Assert.assertEquals("error, status must 200", 200, status);
        Assert.assertEquals("error, return value is error", "123", content);
    }

}
