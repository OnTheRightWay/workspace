package com.nys.crm.staff.dao.impl;


import com.nys.paging.bean.PageBean;
import org.junit.Test;

public class StaffDaoImplTest {
    @Test
    public void findByLoginName() throws Exception {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext*.xml");
//        new Configuration().configure().buildSessionFactory();
//        StaffDao staffDao = (StaffDao) context.getBean("staffDao");
//        Staff xiaowang = staffDao.findByLoginName("xiaowang");
//        System.out.println(xiaowang);
        PageBean<Object> pageBean = new PageBean<>();
        System.out.println(pageBean.getHtml());
    }
}