package com.lanou3g.study;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main4 {
    public static void main(String[] args) {
        //调用jdbcUtil类时，该类会加载进内存
        //也就会执行静态代码块，获得配置文件中的数据

        //执行静态方法execute
        //传入的是ExecuteSQL接口的一个匿名实现类对象
        //这里和我们学线程是很类似

        //传进去的对象，我们先叫它e
        //在execute方法中
        //第一步：根据配置文件中的数据建立连接
        //第二步：调用e的execute方法，将连接传入
            //这里就会回来执行这个匿名实现类的execute方法
            //在这个方法中我们获得state，执行sql语句
            //并且将state作为返回值返回
        //第三步：将e.execute()得到的返回值关闭
        //第四步：关闭连接

        //这种写法叫接口回调
        JDBCUtil.executeSQL(new ExecuteSQL() {

            private ResultSet resultSet;

            @Override
            public Statement execute(Connection conn) throws SQLException{
                Statement state = conn.createStatement();
                resultSet = state.executeQuery("SELECT * FROM hw_user");
                JDBCUtil.showRS(resultSet);
                resultSet.close();
                return state;
            }
        });
    }
}
