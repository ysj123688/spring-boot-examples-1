package com.jerome.repository;

import com.jerome.domain.User;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import javax.transaction.Transactional;

/**
 * 常用例子
 *
 * @author suzhida@soundbus.cn
 * @since 2017/7/12 08:45
 */
public interface UserRepository extends JpaRepository<User, Long> {

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

    /**
     * 使用@Query查询
     */
    @Query("select u from User u where u.name = :name and u.age = :age")
    List<User> withNameAndAge(@Param("name") String name, @Param("age") int age);

    /**
     * 使用@Query查询
     */
    @Query("select u from User u where u.name = ?1")
    List<User> withName(String name);

    /**
     * 使用@NamedQuery查询，实体类要定义@NamedQuery。
     */
    List<User> withNameAndAgeNamedQuery(String name, int age);

    // 更新
    /**
     * 更新操作
     *
     * @return 受影响行数
     */
    @Modifying
    @Transactional
    @Query("update User u set u.name = ?1")
    int setName(String name);

    // 更多操作参考 http://docs.spring.io/spring-data/jpa/docs/1.11.4.RELEASE/reference/html/

}
