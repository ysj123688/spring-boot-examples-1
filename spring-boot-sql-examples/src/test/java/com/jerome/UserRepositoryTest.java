package com.jerome;

import com.jerome.domain.User;
import com.jerome.repository.UserRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * 方便是方便但是性能没有自己写的比如使用mybatis的好
 * 比如：批量删除、新增是一条一条sql执行的
 *
 * @author suzhida@soundbus.cn
 * @since 2017/7/12 09:29
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
        List<User> users = userRepository.findByNameAndAge("Jerome",2);
        users.forEach(System.out::println);
    }

    @Test
    public void withNameAndAgeTest() {
        List<User> users = userRepository.withNameAndAge("Jerome",2);
        users.forEach(System.out::println);
    }

    @Test
    public void withNameTest() {
        List<User> users = userRepository.withName("Jerome");
        users.forEach(System.out::println);
    }

    @Test
    public void withNameAndAgeNamedQueryTest() {
        List<User> users = userRepository.withNameAndAgeNamedQuery("Jerome",26);
        users.forEach(System.out::println);
    }

    @Test
    public void findByNameSortTest() {
        List<User> users = userRepository.findByName("Jerome", new Sort(Sort.Direction.ASC, "age"));
        users.forEach(System.out::println);
    }

    @Test
    public void findByNamePageableTest() {
        List<User> users = userRepository.findByName("Jerome", new PageRequest(0,2));
        users.forEach(System.out::println);
    }

    // 更新
    @Test
    public void setNameTest() {
        int result = userRepository.setName("Jerome");
        System.out.println(result);
    }

    // 删除
    @Test
    public void deleteByIdTest() {
        // 先查询在删除，id不存在报错
        userRepository.delete(1L);
    }

    @Test
    public void deleteByEntityTest() {
        User user = userRepository.findOne(2L);
        userRepository.delete(user);
    }

    @Test
    public void deleteByEntitiesTest() {
        List<User> users = userRepository.findByName("Jerome");
        userRepository.delete(users);
    }

    @Test
    public void deleteAllTest() {
        userRepository.deleteAll();
    }

}
