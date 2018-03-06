package com.lanou.study.dao;

import com.lanou.study.domain.User;

public interface UserDao {
    void add(User user);
    User get(int id);
}
