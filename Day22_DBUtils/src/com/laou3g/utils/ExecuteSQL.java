package com.laou3g.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public interface ExecuteSQL {
    Statement execute(Connection conn) throws SQLException;
}
