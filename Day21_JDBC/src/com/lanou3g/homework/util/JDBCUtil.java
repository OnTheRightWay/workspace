package com.lanou3g.homework.util;

import com.lanou3g.homework.sql.ExecuteSQL;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Properties properties = new Properties();
            properties.load(new FileReader("src/com/lanou3g/homework/JDBC.properties"));
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            database = properties.getProperty("database");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String database;
    private static String url;
    private static String password;
    private static String user;

    public static Connection getConnection() throws SQLException{
        Connection conn = DriverManager.getConnection(url+database,user,password);
        return conn;
    }


    public static void execute(ExecuteSQL e) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        e.execute(conn).close();
        conn.close();
    }
}
