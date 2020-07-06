package cn.pbb.dao;

import cn.pbb.domain.Account;

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
     * 根据用户id查询账户
     * @param uid
     * @return list
     */
    List<Account> findAccountByUid(Integer uid);
}
