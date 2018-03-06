package com.nys.service;

import com.nys.dao.UserDao;
import com.nys.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class UserService {

    private SqlSessionFactory sessionFactory;

    public UserService(){
        try {
            sessionFactory = new SqlSessionFactoryBuilder().build(
                    Resources.getResourceAsStream("SqlMapConfig.xml")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String insert(User user) {
        if (user.getPassword()==null||user.getUsername()==null){
            System.out.println("出错了!!!!");
            return null;
        }
        SqlSession sqlSession = sessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User byUsername = mapper.findByUsername(user.getUsername());
        if (byUsername!=null){
            return "用户名已存在";
        }
        mapper.insert(user);
        sqlSession.commit();
        sqlSession.close();
        return "success";
    }

    public User login(String username, String password) {
        SqlSession sqlSession = sessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.findByUsername(username);
        if (user==null){
            return null;
        }
        if (!user.getPassword().equals(password)){
            return null;
        }
        return user;
    }
}
