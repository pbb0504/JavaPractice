package cn.pbb.service.impl;

import cn.pbb.dao.IAccountDao;
import cn.pbb.dao.impl.AccountDaoImpl;
import cn.pbb.service.IAccountService;

/**
 * @author: pbb
 * @date: 2020/7/6 21:25
 * 业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    private IAccountDao iAccountDao = new AccountDaoImpl();
    public AccountServiceImpl(){
        System.out.println("object created");
    }
    public void saveAccount() {
        iAccountDao.saveAccount();
    }
}
