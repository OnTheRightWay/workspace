package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Util {
    private static DataSource dataSource = null;
    static {
        //加载c3p0配置文件中的配置信息
        //创建c3p0连接池
        dataSource = new ComboPooledDataSource();
    }


    //这个QueryRunner会自动获取连接池中的连接
    //使用时，不必传入connection参数
    public static QueryRunner getQuery(){
        //通过连接池获得QueryRunner
        QueryRunner query = new QueryRunner(dataSource);
        return query;
    }


    public static Connection getconn(){
        try {
            //通过连接池获得连接
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
