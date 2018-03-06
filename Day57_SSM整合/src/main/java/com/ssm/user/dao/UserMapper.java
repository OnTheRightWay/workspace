package com.ssm.user.dao;

import com.ssm.user.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User findUserById(int id);

    void insertUser(User user);
}
