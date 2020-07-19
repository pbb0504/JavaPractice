package cn.pbb.dao;

import cn.pbb.domain.Account;

/**
 * @author: pbb
 * @date: 2020/7/19 13:06
 */
public interface IAccountDao {
    /**
     * find by id
     *
     * @param id
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * find by name
     *
     * @param name
     * @return
     */
    Account findAccountByName(String name);

    /**
     * update
     * @param account
     */
    void updateAccount(Account account);
}
