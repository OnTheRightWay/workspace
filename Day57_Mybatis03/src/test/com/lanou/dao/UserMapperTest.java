package com.lanou.dao;

import com.lanou.domain.Orders;
import com.lanou.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserMapperTest {
    private UserMapper userMapper;
    private SqlSession sqlSession;
    private OrdersMapper ordersMapper;

    @Before
    public void setUp() throws Exception {
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(
                Resources.getResourceAsStream("mybatis-config.xml")
        );
        sqlSession = build.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
        ordersMapper = sqlSession.getMapper(OrdersMapper.class);
    }

    @Test
    public void findUser() throws Exception {
        List<User> user = userMapper.findUser();
        for (User user1 : user) {
            System.out.println(user1);
        }
    }

    @Test
    public void insertUser() throws Exception {
        User user = new User();
        user.setUsername("马化腾");
        userMapper.insertUser(user);

        //先提交一次，将马化腾更新到数据库
        sqlSession.commit();

        Orders orders1 =new Orders();
        orders1.setNumber(1110);
        orders1.setUser_id(user.getId());
        ordersMapper.insertOrders(orders1);

        Orders orders2 =new Orders();
        orders1.setNumber(1111);
        orders2.setUser_id(user.getId());
        ordersMapper.insertOrders(orders2);

        Orders orders3 =new Orders();
        orders1.setNumber(1112);
        orders3.setUser_id(user.getId());
        ordersMapper.insertOrders(orders3);

        //提交插入的Orders
        sqlSession.commit();

        List<Orders> orders = new ArrayList<Orders>();
        orders.add(orders1);
        orders.add(orders2);
        orders.add(orders3);
        user.setOrdersList(orders);
        System.out.println(user);
    }

    @After
    public void tearDown() throws Exception {
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test() throws Exception {
        UserMapper userMapper1 = sqlSession.getMapper(UserMapper.class);
        UserMapper userMapper2 = sqlSession.getMapper(UserMapper.class);
        UserMapper userMapper3 = sqlSession.getMapper(UserMapper.class);

        List<User> user1 = userMapper1.findUser();
        List<User> user2 = userMapper2.findUser();
        List<User> user3 = userMapper3.findUser();
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
    }
}