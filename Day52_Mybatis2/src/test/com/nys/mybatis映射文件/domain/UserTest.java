package com.nys.mybatis映射文件.domain;

import com.nys.mybatis映射文件.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class UserTest {

    private SqlSessionFactory sessionFactory;

    @Before
    public void setUp() throws Exception {
        sessionFactory = new SqlSessionFactoryBuilder().build(
                Resources.getResourceAsStream("SqlMapConfig.xml")
        );
    }

    @Test
    public void findUserById() throws Exception {
        SqlSession sqlSession = sessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User userById = mapper.findUserById(15);
        System.out.println(userById);
        sqlSession.close();
    }

    @Test
    public void insertUser() throws Exception {
        SqlSession sqlSession = sessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = new User(0,"张三","男",new Date(),"上海");
        mapper.insertUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void findUsersByQueryV0() throws Exception {
        SqlSession sqlSession = sessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        UserExt userExt = new UserExt("女","王");
        UserQueryV0 userQueryV0 = new UserQueryV0(userExt);
        List<User> users = mapper.findUsersByQueryV0(userQueryV0);
        sqlSession.close();
        System.out.println(Arrays.toString(users.toArray()));
    }

    @Test
    public void findUsersCount() throws Exception {
        SqlSession sqlSession = sessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        UserExt userExt = new UserExt("女","王");
        UserQueryV0 userQueryV0 = new UserQueryV0(userExt);
        int count = mapper.findUsersCount(userQueryV0);
        sqlSession.close();
        System.out.println(count);
    }

    @Test
    public void findUserList() throws Exception {
        SqlSession sqlSession = sessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        UserExt userExt = new UserExt("",null);
        UserQueryV0 userQueryV0 = new UserQueryV0(userExt);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        userQueryV0.setIdList(list);
        List<User> userList = mapper.findUserList(userQueryV0);
        System.out.println(Arrays.toString(userList.toArray()));
    }

    @Test
    public void findUserByIdList() throws Exception {
        SqlSession sqlSession = sessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        List<User> userList = mapper.findUserByIdList(list);
        System.out.println(Arrays.toString(userList.toArray()));
    }
}