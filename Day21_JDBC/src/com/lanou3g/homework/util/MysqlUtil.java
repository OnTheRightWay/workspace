package com.lanou3g.homework.util;

import com.lanou3g.homework.bean.Person;
import com.lanou3g.homework.sql.QueryRunnerAndClose;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.BeanMapHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class MysqlUtil {
    public static String getdata(String username, String columnName){
        Connection conn = null;
        try {
            conn = JDBCUtil.getConnection();
            PreparedStatement pstate = conn.prepareStatement(
                    "SELECT * FROM person WHERE username=?;");
//            pstate.setString(1,columnName);
            pstate.setString(1,username);
            ResultSet rs = pstate.executeQuery();
            String s =null;
            while (rs.next()) {
                s = rs.getString(columnName);
            }
            conn.close();
            return s;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String query(String username,int l,String... columnNames) throws SQLException {
        QueryRunnerAndClose qr = new QueryRunnerAndClose();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < columnNames.length; i++) {
            sb.append(columnNames[i]);
            if (i<columnNames.length-1){
                sb.append(",");
            }
        }
        Map<String, Object> objectMap = qr.query(
                JDBCUtil.getConnection()
                , "select "+sb.toString()+" from person where username=?"
                , new MapHandler(), username);
        return objectMap.toString();


    }
    public static String query(String... usernames) throws SQLException {
        QueryRunnerAndClose qr = new QueryRunnerAndClose();
        List<Person> peoples = qr.query(JDBCUtil.getConnection()
                , "select * from person"
                , new BeanListHandler<Person>(Person.class));
        StringBuffer sb = new StringBuffer();
        boolean isTrue=false;
        for (int i = 0; i < usernames.length; i++) {
            for (Person p : peoples) {
                if (usernames[i].equals(p.getUserName())){
                    sb.append("用户名:"+p.getUserName()+"\t密码:"+p.getPassword()+
                            "\t姓名:"+p.getName()+"\t工作"+p.getJob()).append("\n");
                    isTrue=true;

                }
            }
        }
        if (isTrue){
            return sb.toString();
        }
        if (usernames.length==0){
            sb.setLength(0);
            for (Person person:peoples) {
                sb.append(person.toString()).append("\n");
            }
            return sb.toString();
        }
        return null;
    }


    public static void insert(String username,String password,String name,String job){
        Connection conn = null;
        try {
            conn = JDBCUtil.getConnection();
            PreparedStatement pstate = conn.prepareStatement("INSERT INTO person VALUES(?,?,?,?)");
            pstate.setString(1,username);
            pstate.setString(2,password);
            pstate.setString(3,name);
            pstate.setString(4,job);
            pstate.execute();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void update(String username,String columnName,String newData) throws SQLException {
        Connection conn =JDBCUtil.getConnection();
        PreparedStatement pstate = conn.prepareStatement("UPDATE person SET "+columnName+"=? WHERE username=?");
//        pstate.setString(1,columnName);
        pstate.setString(1,newData);
        pstate.setString(2,username);
        pstate.executeUpdate();
        conn.close();
    }
    public static void delete(String username) throws SQLException {
        Connection conn =JDBCUtil.getConnection();
        PreparedStatement pstate = conn.prepareStatement("DELETE FROM person WHERE username=?");
        pstate.setString(1,username);
        pstate.execute();
        conn.close();
    }
}
