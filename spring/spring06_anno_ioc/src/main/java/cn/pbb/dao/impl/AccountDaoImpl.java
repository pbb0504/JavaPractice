package cn.pbb.dao.impl;

import cn.pbb.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * @author: pbb
 * @date: 2020/7/6 21:28
 * 账户的持久层实现类
 */
@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
    @Override
    public void saveAccount() {
        System.out.println("saved1111111111111");
    }
}
