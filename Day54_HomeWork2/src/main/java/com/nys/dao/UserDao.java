package com.nys.dao;

import com.nys.domain.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao extends HibernateDaoSupport{
    public void insert(User user){
        getHibernateTemplate().save(user);
    }
    public User findByUsername(String username){
        List<?> list = getHibernateTemplate().find(
                "from User u where u.username=?", username
        );
        if (list.size()==0){
            return null;
        }
        return (User) list.get(0);
    }
}
