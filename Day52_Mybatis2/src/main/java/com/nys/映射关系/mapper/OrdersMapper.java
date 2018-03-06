package com.nys.映射关系.mapper;

import com.nys.映射关系.domain.Orders;
import com.nys.映射关系.domain.OrdersExt;
import com.nys.映射关系.domain.User;

import java.util.List;

public interface OrdersMapper {
    List<OrdersExt> findOrdersUser();
    List<Orders> findOrdersUserRstMap();
    List<Orders> findOrdersAndOrderDetailRstMap();
    List<User> findUserAndItemsRstMap();
}
