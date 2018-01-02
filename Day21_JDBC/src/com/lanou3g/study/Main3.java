package com.lanou3g.study;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Main3 {
    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/day19";
        Properties info = new Properties();
        info.load(new FileReader("src/com/lanou3g/study/db.properties"));
        Connection conn = DriverManager.getConnection(url, info);
        Statement state = conn.createStatement();
        String update = "update hw_user set uname='李二狗' where uname='张一山'";
        boolean execute = state.execute(update);
//        ResultSet rs = state.executeQuery("SELECT * FROM hw_user");
//        while (rs.next()){
//            System.out.print(rs.getString(1)+"\t");
//            System.out.print(rs.getString(2)+"\t");
//            System.out.print(rs.getString(3)+"\t");
//            System.out.print(rs.getString(4)+"\t");
//            System.out.println();
//        }
//        rs.close();
        state.close();
        conn.close();

    }
}
