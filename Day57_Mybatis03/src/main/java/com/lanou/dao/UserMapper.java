package com.lanou.dao;

import com.lanou.domain.User;

import java.util.List;

public interface UserMapper {
    List<User> findUser();
    void insertUser(User user);
}
