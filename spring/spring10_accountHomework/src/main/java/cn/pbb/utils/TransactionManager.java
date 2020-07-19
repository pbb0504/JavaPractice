package cn.pbb.utils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author: pbb
 * @date: 2020/7/14 14:11
 * 和书屋管理相关的工具类，包含了开启事务，提交事务回滚事务和释放连接
 */
public class TransactionManager {

    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     * begin
     */
    public void beginTransaction() {
        try {
            connectionUtils.getConnection().setAutoCommit(false);
            System.out.println("start");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * commit
     */
    public void commit() {
        try {
            Connection connection = connectionUtils.getConnection();
            connection.setAutoCommit(false);
            connection.commit();
            System.out.println("commit");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * rollback
     */
    public void rollback() {
        try {
            connectionUtils.getConnection().rollback();
            System.out.println("rollback");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * release
     */
    public void release() {
        try {
            connectionUtils.getConnection().close();
            connectionUtils.removeConnection();
            System.out.println("release");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
