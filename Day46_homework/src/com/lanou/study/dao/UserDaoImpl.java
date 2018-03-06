package com.lanou.study.dao;

import com.lanou.study.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

//@Repository("userDao")
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
//    @Autowired
    private User user;
    @Override
    public void get() {
        User user = getHibernateTemplate().get(User.class,1);
        System.out.println(user.toString());
    }

    public void setUser(User user) {
        this.user = user;
    }
}
