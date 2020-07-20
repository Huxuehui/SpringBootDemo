package com.foo.demo.dao;

import com.foo.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUserName(String name);

    List<User> findByUserNameOrNickName(String name, String nickName);
}
