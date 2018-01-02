package com.lanou3g.homework.sql;

import java.sql.Connection;
import java.sql.Statement;

public interface ExecuteSQL {
    Statement execute(Connection conn);
}
