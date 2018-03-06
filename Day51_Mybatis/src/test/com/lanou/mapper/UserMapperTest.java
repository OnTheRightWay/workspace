package com.lanou.mapper;

import com.lanou.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resources;

import java.util.Date;

import static org.junit.Assert.*;

public class UserMapperTest {

    private SqlSessionFactory sessionFactory;

    @Before
    public void setUp() throws Exception {
        sessionFactory = new SqlSessionFactoryBuilder().build(org.apache.ibatis.io.Resources.getResourceAsStream("SqlMapConfig.xml"));
    }



    @Test
    public void findUserById() throws Exception {
        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.findUserById(14);
        System.out.println(userById);
        sqlSession.close();
    }

    @Test
    public void updateUser() throws Exception {
        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User
                (14,"李国易","不男不nv",new Date(),"中南海");

        mapper.updateUser(user);
        sqlSession.close();
    }
}