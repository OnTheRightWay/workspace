package com.laou3g.study;

import com.laou3g.utils.JDBCUtil;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public class WhQueryRunnerTest {
    /*
        根据需求结果的类型
            选择ResultSetHandler的实现类
        如果结果集为单行单列:ScalarHandler
        如果想要一个对象:BeanHandler
        如果想要一个对象的集合:BeanListHandler
        如果想要一个Map:MapHandler
        如果想要一个Map集合:MapListHandler
        如果想要一个数组:ArrayHandler
        如果想要一个数组的集合:ArrayListHandler
     */

    @Test
    public void queryByParams() throws SQLException {
        long query = new WhQueryRunner().query(
                JDBCUtil.getConnection(),
                "select count(*) from hw_user",
                new ScalarHandler<Long>()
//                "李小龙"
        );

        //Number类
        //可以接收任何数字类型的值
        //Number类中有获取各种整形值的方法
        Number number=query;
        //获得int值
        int i = number.intValue();


        System.out.println(query);
//        for (Object[] o :query) {
//            System.out.println(Arrays.toString(o));
//        }
    }

    @Test
    public void queryBean() throws SQLException {
        List<User> users = new WhQueryRunner().query(
                JDBCUtil.getConnection(),
                "select * from hw_user",
                new BeanListHandler<User>(User.class)
        );
        System.out.println(users);
    }

    @Test
    public void queryMap() throws SQLException {
        Map<String, Object> objectMap = new WhQueryRunner().query(
                JDBCUtil.getConnection(),
                "select * from hw_user",
                new MapHandler()
        );
        System.out.println(objectMap);
    }

}