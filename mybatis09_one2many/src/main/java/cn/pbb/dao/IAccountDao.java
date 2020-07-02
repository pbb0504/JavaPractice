package cn.pbb.dao;

import cn.pbb.domain.Account;
import cn.pbb.domain.AccountUser;

import java.util.List;

/**
 * @author 13053
 */
public interface IAccountDao {
    /**
     * 查询所有账户，还要获取当当前账户的所属用户
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有账户，并且查询对应用户名和地址
     * @return
     */
    List<AccountUser> findAllAccount();
}
