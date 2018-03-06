package com.lanou3g.aop;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Override
    public void add() {
//        int a = 10/0;
        System.out.println("  ---------add---------");
    }

    @Override
    public String get(){
        return "托儿索-儿童劫-红领烬-提款姬-喜之螂-小学僧-洞庭狐-橡皮妮";
    }

}
