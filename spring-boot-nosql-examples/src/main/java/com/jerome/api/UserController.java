package com.jerome.api;

import com.jerome.domain.User;
import com.jerome.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author suzhida
 * @since 2017/8/17 23:28
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public User save() {
        return userRepository.save(new User("Jerome", 12));
    }

}
