package com.jerome.mvc;

import com.jerome.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

/**
 * @author suzhida@soundbus.cn
 * @since 2017/7/1 08:33
 */
@Controller
@Slf4j
public class SpringMVCExample {

    @RequestMapping(value = "user", method = RequestMethod.GET)
    // 不同路径相同方法 value = { "/user1", "/user2" }
    public String get(@RequestParam("id") String userId, HttpServletRequest request) {
        // String userId 传参为:userId
        // @RequestParam String userId 传参为:userId
        // @RequestParam("id") String userId 传参为:id
        // User user 表示xxx?name=jerome&age=26
        log.debug("url = {}, user id = {}", request.getRequestURL(), userId);
        return userId;
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public String getRESTful(@PathVariable("id") String userId) {
        // @PathVariable String userId 传参为:userId
        // @PathVariable("id") String userId 传参为:id
        log.debug("user id = {}", userId);
        return userId;
    }

    /**
     * @ResponseBody 支持返回值放在response体内，而不是返回一个页面。<br/>
     * 所以一般纯接口的项目直接使用类组合注解@RestController即有ResponseBody和Controller的功能
     *
     * @RequestBody 允许request的参数在request体内，而不是在链接后面。
     */
    // @ResponseBody 也可以注解在方法
    @RequestMapping(value = "user", method = RequestMethod.POST)
    public @ResponseBody User save(@RequestBody User user) {
        return new User("jerome", 26);
    }

}
