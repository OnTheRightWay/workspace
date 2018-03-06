package com.nys.dao;

import com.nys.domain.User;

public interface UserDao {
    User findUserById(int id);
}
