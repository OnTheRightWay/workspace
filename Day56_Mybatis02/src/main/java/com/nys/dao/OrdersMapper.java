package com.nys.dao;

import com.nys.domain.Orders;
import com.nys.domain.OrdersExt;

import java.util.List;

public interface OrdersMapper {
    List<Orders> findOrdersUser();
    List<Orders> findOrdersAll();
    List<Orders> findItems();
}
