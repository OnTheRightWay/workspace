package com.nys.dao;

import com.nys.domain.Orders;
import com.nys.domain.OrdersExt;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class OrdersMapperTest {
    private OrdersMapper mapper;
    private SqlSession sqlSession;

    @Before
    public void setUp() throws Exception {
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
        sqlSession = sessionFactory.openSession();
        mapper= sqlSession.getMapper(OrdersMapper.class);
    }

    @Test
    public void findOrdersUser() throws Exception {
//        List<OrdersExt> ordersUser = mapper.findOrdersUser();
//        for (OrdersExt ordersExt : ordersUser) {
//            System.out.println(ordersExt.getNumber());
//            System.out.println(ordersExt.getAddress());
//        }
        List<Orders> ordersUser = mapper.findOrdersUser();
        for (Orders orders : ordersUser) {
            System.out.println(orders.getUser().getUsername());
            System.out.println(orders.getNumber());
        }
    }

    @Test
    public void findOrdersAll() throws Exception {
        List<Orders> ordersAll = mapper.findOrdersAll();
        for (Orders orders : ordersAll) {
            System.out.println(orders);
        }
    }

    @Test
    public void findItems() throws Exception {
        List<Orders> items = mapper.findItems();
        for (Orders orders : items) {
            System.out.println(orders);
        }
    }

    @After
    public void tearDown() throws Exception {
        sqlSession.commit();
        sqlSession.close();
    }
}