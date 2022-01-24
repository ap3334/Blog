package com.cos.blog.repository;

import com.cos.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * DAO
 * 이미 함수를 다 가지고 있음
 * 자동으로 bean 등록이 됨
  */
@Repository // 생략 가능
public interface UserRepository extends JpaRepository<User, Integer> {

}

// JPA Naming 전략
// SELECT * FROM user WHERE username =? 1 AND password = ? 2;
//    User findByUserNameAndPassword(String username, String password);

    /*@Query(value = "SELECT * FROM user WHERE username = ?1 AND password = ?2", nativeQuery = true)
    User login(String username, String password);*/