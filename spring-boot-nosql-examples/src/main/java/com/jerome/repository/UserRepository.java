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

    // 查询
    /**
     * JPQL:select u from User u where u.name = ?1
     */
    List<User> findByName(String name);

    /**
     * JPQL:select u from User u where u.name = ?1 limit 2
     * == findFirst2ByName
     */
    List<User> findTop2ByName(String name);

    /**
     * JPQL:select u from User u where u.name like ?1
     */
    List<User> findByNameLike(String name);

    /**
     * JPQL:select u from User u where u.name = ?1 and u.age = ?2
     */
    List<User> findByNameAndAge(String name, int age);

    /**
     * JPQL:select u from User u where u.name = ?1 order by ?2
     */
    List<User> findByName(String name, Sort sort);

    /**
     * JPQL:select u from User u where u.name = ?1 limit (?2)
     */
    List<User> findByName(String name, Pageable pageable);

}
