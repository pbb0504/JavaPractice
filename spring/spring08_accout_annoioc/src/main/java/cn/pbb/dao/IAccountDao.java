package cn.pbb.dao;

import cn.pbb.domain.Account;

import java.util.List;

/**
 * @author: pbb
 * @date: 2020/7/12 11:17
 */
public interface IAccountDao {
    /**
     * findAllAccounts
     * @return list
     */
    List<Account> findAllAccount();

    /**
     * find one
     * @return account
     */
    Account findAccountById(Integer id);

    /**
     * save an account
     * @param account
     */
    void saveAccount(Account account);

    /**
     * update
     * @param account
     */
    void updateAccount(Account account);

    /**
     * delete by id
     * @param id
     */
    void deleteAccount(Integer id);
}
