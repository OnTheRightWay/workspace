package com.nys.crm.user.dao;

import com.nys.crm.user.dao.impl.UserDao;
import com.nys.crm.user.domain.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{
    @Override
    public void get() {
        User user = getHibernateTemplate().get(User.class, 1);
        System.out.println(user);
    }
}
