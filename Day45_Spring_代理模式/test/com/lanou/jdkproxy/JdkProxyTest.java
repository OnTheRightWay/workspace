package com.lanou.jdkproxy;

import org.junit.Test;

import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JdkProxyTest {
    @Test
    public void jdkTest() throws Exception {
        JdkUserDao jdkUserDao = new JdkUserDaoImpl();
        JdkTransaction jdkTransaction = new JdkTransaction();
        JdkProxy jdkProxy = new JdkProxy(jdkUserDao,jdkTransaction);
        JdkUserDao o = (JdkUserDao) Proxy.newProxyInstance(
                jdkUserDao.getClass().getClassLoader()
                , jdkUserDao.getClass().getInterfaces()
                , jdkProxy
        );
        o.add();

//        System.out.println(Arrays.toString(o.getClass().getInterfaces()));
    }
}