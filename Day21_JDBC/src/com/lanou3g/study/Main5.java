package com.lanou3g.study;

import java.sql.*;

public class Main5 {
    /**
     * 1.PrepareStatement可以使用动态参数
     *      Statement只能使用静态的sql语句
     * 2.防止sql注入
     *      什么是sql注入
     *   getdata * from user where username=? and password=?;
     */
    public static void main(String[] args) {
        JDBCUtil.executeSQL(conn -> {
            try {
                PreparedStatement pstate = conn.prepareStatement(
                        "SELECT  * FROM hw_user WHERE loc=? AND age>?;");
                pstate.setString(1,"北京");
                pstate.setInt(2,20);

                ResultSet rs = pstate.executeQuery();
                JDBCUtil.showRS(rs);
                return pstate;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        });

    }
}
