package com.nys.映射关系.domain;

import com.nys.映射关系.mapper.OrdersMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class OrdersTest {

    private SqlSessionFactory sessionFactory;

    @Before
    public void setUp() throws Exception {
        sessionFactory = new SqlSessionFactoryBuilder().build(
                Resources.getResourceAsStream("SqlMapConfig.xml")
        );
    }

    @Test
    public void findOrdersUser() throws Exception {
        SqlSession sqlSession = sessionFactory.openSession();
        OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
        List<OrdersExt> ordersUser = mapper.findOrdersUser();
        System.out.println(Arrays.toString(ordersUser.toArray()));
        sqlSession.close();
    }

    @Test
    public void findOrdersUserRstMap() throws Exception {
        SqlSession sqlSession = sessionFactory.openSession();
        OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> list = mapper.findOrdersUserRstMap();
        System.out.println(Arrays.toString(list.toArray()));
        sqlSession.close();
    }

    @Test
    public void findOrdersAndOrderDetailRstMap() throws Exception {
        SqlSession sqlSession = sessionFactory.openSession();
        OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> list = mapper.findOrdersAndOrderDetailRstMap();
        System.out.println(Arrays.toString(list.toArray()));
        sqlSession.close();
    }

    @Test
    public void findUserAndItemsRstMap() throws Exception {
        SqlSession sqlSession = sessionFactory.openSession();
        OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
        List<User> list = mapper.findUserAndItemsRstMap();
        System.out.println(Arrays.toString(list.toArray()));
        sqlSession.close();
    }
}