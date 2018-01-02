package com.lanou3g.homework.util;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class MysqlUtilTest {
    @Test
    public void test1() throws SQLException {

        System.out.println("查一个人的所有信息");
        System.out.println(MysqlUtil.query("yuanYingYing"));
        System.out.println("查多个人的所有信息");
        System.out.println(MysqlUtil.query("yuanYingYing","zhangSan"));
        System.out.println("查指定人的，指定2个属性的信息");
        System.out.println(MysqlUtil.query("yuanYingYing", 1, "name", "job"));
        System.out.println("查指定人的，指定4个属性的信息");
        System.out.println(MysqlUtil.query("yuanYingYing", 1, "username","password","name", "job"));
    }

}