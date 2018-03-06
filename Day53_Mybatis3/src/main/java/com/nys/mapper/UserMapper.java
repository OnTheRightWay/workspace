package com.nys.mapper;

import com.nys.domain.User;

import java.util.List;

public interface UserMapper {
    List<User> findUserOrders();
}
