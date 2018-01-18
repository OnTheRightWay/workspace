package com.lanou3g.action;

import com.lanou3g.BaseDao;
import com.lanou3g.BaseDaoImpl;
import com.lanou3g.bean.Demo;

public class DemoAction {
    private BaseDao<Demo> baseDao = new BaseDaoImpl<>();
    public String demo(){
        //假装我是一个Struts2的action
        //毕竟POJO类也可以作为action使用
        baseDao.add(new Demo());
        return "success";
    }
}
