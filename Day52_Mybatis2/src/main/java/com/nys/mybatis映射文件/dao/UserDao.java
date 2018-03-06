package com.nys.mybatis映射文件.dao;

import com.nys.mybatis映射文件.domain.User;
import com.nys.mybatis映射文件.domain.UserQueryV0;

import java.util.List;

public interface UserDao {
    User findUserById(int id);
    void insertUser(User user);
    List<User> findUsersByQueryV0(UserQueryV0 userExt);
    int findUsersCount(UserQueryV0 userQueryV0);
    List<User> findUserList(UserQueryV0 userQueryV0);
    List<User> findUserByIdList(List<Integer> list);
}
