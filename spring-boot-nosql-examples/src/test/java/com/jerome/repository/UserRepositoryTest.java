package com.jerome.repository;

import com.jerome.domain.User;
import com.jerome.repository.UserRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author suzhida
 * @since 2017/8/16 23:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    // 新增
    @Test
    public void saveOneTest() {
        userRepository.save(new User("Jerome", 12));
    }

    @Test
    public void saveListTest() {
        List<User> users = new ArrayList<>();
        users.add(new User("Jelly", 25));
        users.add(new User("Jerome", 26));
        users.add(new User("Jerome", 26));
        users.add(new User("Nemo", 2));
        userRepository.save(users);
    }

    // 查询
    @Test
    public void findOneTest() {
        User user = userRepository.findOne("59a36582e0f5f5e7430ecda5");
        System.out.println(user);
    }

    @Test
    public void findByNameTest() {
        List<User> users = userRepository.findByName("Jerome");
        users.forEach(System.out::println);
    }

    @Test
    public void findTop2ByNameTest() {
        List<User> users = userRepository.findTop2ByName("Jerome");
        users.forEach(System.out::println);
    }

    @Test
    public void findByNameLikeTest() {
        List<User> users = userRepository.findByNameLike("Jerome");
        users.forEach(System.out::println);
    }

    @Test
    public void findByNameAndAgeTest() {
        List<User> users = userRepository.findByNameAndAge("Jerome", 12);
        users.forEach(System.out::println);
    }

    @Test
    public void findByNameOrderByAgeDescTest() {
        List<User> users = userRepository.findByNameOrderByAgeDesc("Jerome");
        users.forEach(System.out::println);
    }

    @Test
    public void findByNamePageTest() {
        List<User> users = userRepository.findByName("Jerome", new PageRequest(0, 2));
        users.forEach(System.out::println);
    }

}
