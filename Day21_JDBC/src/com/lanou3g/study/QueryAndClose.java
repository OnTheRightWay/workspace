package com.lanou3g.study;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class QueryAndClose {
    public static <T> T query( String sql, ResultSetHandler<T> rs) throws SQLException {
        QueryRunner qr = new QueryRunner();
        Connection conn = JDBCUtil.getConnection();
        T t = qr.query(conn,sql,rs);
        conn.close();
        return t;
    }
}
