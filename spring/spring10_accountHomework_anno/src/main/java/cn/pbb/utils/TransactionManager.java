package cn.pbb.utils;

import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author: pbb
 * @date: 2020/7/14 14:11
 * 和书屋管理相关的工具类，包含了开启事务，提交事务回滚事务和释放连接
 */
@Component
@Aspect
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* cn.pbb.service.impl.*.*(..))")
    private void pt1() {
    }

    /**
     * begin
     */
    @Before("pt1()")
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
    @AfterReturning("pt1()")
    public void commit() {
        try {
            connectionUtils.getConnection().commit();

            System.out.println("commit");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * rollback
     */
    @AfterThrowing("pt1()")
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
    @After("pt1()")
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
