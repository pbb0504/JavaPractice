package cn.pbb.dao.impl;

import cn.pbb.dao.IAccountDao;
import cn.pbb.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author: pbb
 * @date: 2020/7/19 13:08
 */
public class AccountDaoImpl01 extends JdbcDaoSupport implements IAccountDao {

    @Override
    public Account findAccountById(Integer id) {
        List<Account> accounts = getJdbcTemplate().query("select * from account2 where id = ?", new BeanPropertyRowMapper<Account>(Account.class), id);
        return accounts.isEmpty() ? null : accounts.get(0);
    }

    @Override
    public Account findAccountByName(String name) {
        List<Account> accounts = getJdbcTemplate().query("select * from account2 where name = ?", new BeanPropertyRowMapper<Account>(Account.class), name);
        if (accounts.isEmpty()) {
            return null;
        }
        if (accounts.size() > 1) {
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        getJdbcTemplate().update("update account2 set name = ?, money = ? where id = ?", new BeanPropertyRowMapper<Account>(Account.class), account.getName(),account.getMoney(), account.getId());
    }
}
