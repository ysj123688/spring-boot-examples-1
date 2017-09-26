package com.jerome.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author suzhida
 * @since 2017/7/19 10:12
 */
@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping(method = RequestMethod.GET, value = "find")
    public String find() {
        return "123";
    }

}
