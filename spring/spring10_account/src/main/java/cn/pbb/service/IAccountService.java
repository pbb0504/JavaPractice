package cn.pbb.service;

import cn.pbb.domain.Account;

import javax.security.auth.login.AccountException;
import java.util.List;

/**
 * @author: pbb
 * @date: 2020/7/12 11:10
 */
public interface IAccountService {
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
     * @param id id
     */
    void deleteAccount(Integer id);

    /**
     * 转账
     * @param sourceName from
     * @param targetName to
     * @param money how much
     */
    void transfer(String sourceName, String targetName, Float money);
}
