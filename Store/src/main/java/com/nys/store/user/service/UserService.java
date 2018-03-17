package com.nys.store.user.service;

import com.nys.store.user.domain.User;

public interface UserService {

    User selectByLogin(User user);

    User selectByPhone(String phone);

    User selectByUsername(String user_name);

    void insertUser(User user);
}
