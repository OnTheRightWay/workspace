package com.nys.dao;

import com.nys.domain.User;

import java.io.IOException;
import java.util.List;

public interface UserDao {
    User findById(int id) throws IOException;
    List<User> findAll();
    void insertUser(User user);
}
