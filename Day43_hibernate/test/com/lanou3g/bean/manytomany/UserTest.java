package com.lanou3g.bean.manytomany;

import com.lanou3g.util.HibernateUtil;
import org.junit.Test;

public class UserTest {
    @Test
    public void save(){
        HibernateUtil.handle(session -> {
            User user = new User();
            user.setUname("张三");
            Role role = new Role();
            role.setRname("管理员");

            role.getUsers().add(user);
            user.getRoles().add(role);

            session.save(role);
            return null;
        });
    }
    @Test
    public void get(){
        HibernateUtil.handle(session -> {
            User user = session.get(User.class, "402894ea610d818601610d8188a50001");
            System.out.println(user.getRoles());
            System.out.println(user);
            return user;
        });
    }

}