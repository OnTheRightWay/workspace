package com.lanou.mapper;

import com.lanou.domain.User;

public interface UserMapper {
    User findUserById(int id);
    void updateUser(User user);
}
