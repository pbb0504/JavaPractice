package cn.pbb.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author: pbb
 * @date: 2020/7/14 14:00
 * 连接的工具类，用于从数据源中获取一个连接，并且实现和线程的绑定
 */
public class ConnectionUtils {
    private ThreadLocal<Connection> tl = new ThreadLocal<>();


    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * get current thread's connection
     *
     * @return connection
     */
    public Connection getConnection() {
        Connection connection = tl.get();
        // judge if connection exists
        if (connection == null) {
            // get a connection from datasource put it in threadLocal
            try {
                connection = dataSource.getConnection();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            tl.set(connection);
        }
        return connection;
    }

    /**
     * remove a connection
     */
    public void removeConnection() {
        tl.remove();
    }
}
