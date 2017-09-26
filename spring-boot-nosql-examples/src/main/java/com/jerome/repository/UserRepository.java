package com.jerome.repository;

import com.jerome.domain.User;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 常用例子
 *
 * @author suzhida
 * @since 2017/7/12 08:45
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByName(String name);

    List<User> findTop2ByName(String name);

    /** JPQL:select u from User u where u.name like ?1 */
    List<User> findByNameLike(String name);

    List<User> findByNameAndAge(String name, int age);

    List<User> findByNameOrderByAgeDesc(String name);

    List<User> findByName(String name, Pageable pageable);

}
