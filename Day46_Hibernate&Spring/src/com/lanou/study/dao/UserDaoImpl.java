package com.lanou.study.dao;

import com.lanou.study.domain.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

    private User user;

    @Override
    public void add() {
        this.getHibernateTemplate().save(user);
        System.out.println("添加好了");
    }

    public void setUser(User user) {
        this.user = user;
    }
}
