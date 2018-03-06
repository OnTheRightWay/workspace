package com.nys.dao;

import com.nys.domain.User;

public interface UserDao {
    void insert(User user);
    User findByUsername(String username);
}
