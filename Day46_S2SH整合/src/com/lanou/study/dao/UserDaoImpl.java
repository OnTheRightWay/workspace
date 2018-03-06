package com.lanou.study.dao;

import com.lanou.study.domain.User;
import com.nys.util.HibernateUtil;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    private User user;

    @Override
    public void add(User user) {
        this.getHibernateTemplate().save(user);
        System.out.println("添加好了");
    }

    @Override
    public User get(int id) {
        return this.getHibernateTemplate().get(User.class,id);
    }

    public void setUser(User user) {
        this.user = user;
    }
}
