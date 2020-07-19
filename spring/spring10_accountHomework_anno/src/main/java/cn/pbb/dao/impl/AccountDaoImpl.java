package cn.pbb.dao.impl;

import cn.pbb.dao.IAccountDao;
import cn.pbb.domain.Account;
import cn.pbb.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: pbb
 * @date: 2020/7/12 11:18
 */
@Repository
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private QueryRunner runner;
    @Autowired
    private ConnectionUtils connectionUtils;

    @Override
    public List<Account> findAllAccount() {
        try {
            return runner.query(connectionUtils.getConnection(), "select * from account2", new BeanListHandler<Account>(Account.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Account findAccountById(Integer id) {
        try {
            return runner.query(connectionUtils.getConnection(), "select * from account2 where id = ?", new BeanHandler<Account>(Account.class), id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveAccount(Account account) {
        try {
            runner.update(connectionUtils.getConnection(), "insert into account2(name,money)values(?,?)", account.getName(), account.getMoney());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            runner.update(connectionUtils.getConnection(), "update account2 set name=?,money=? where id=?", account.getName(), account.getMoney(), account.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteAccount(Integer id) {
        try {
            runner.update(connectionUtils.getConnection(), "delete from account2 where id=?", id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Account findAccountByName(String name) {
        try {
            List<Account> accounts = runner.query(connectionUtils.getConnection(), "select * from account2 where name = ?", new BeanListHandler<Account>(Account.class), name);
            if (accounts == null || accounts.size() == 0) {
                return null;
            }
            if (accounts.size() > 1) {
                throw new RuntimeException("结果不唯一，数据有错误");
            }
            return accounts.get(0);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
