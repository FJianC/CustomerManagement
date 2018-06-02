package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author FJianC
 */
public class JdbcUtils {
    /**
     * c3p0连接池对象
     * */
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql");

    /**
     * 获取c3p0连接池对象
     * @return
     * */
    public static DataSource getDataSource() {
        return dataSource;
    }

    /**
     * 获得数据库连接
     * @return
     * @throws SQLException
     * */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭数据库连接
     * @param conn
     * */
    public static void closeConn(Connection conn) {
        try {
            if (conn != null && conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
