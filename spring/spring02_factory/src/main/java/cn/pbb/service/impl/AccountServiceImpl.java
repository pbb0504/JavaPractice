package cn.pbb.service.impl;

import cn.pbb.dao.IAccountDao;
import cn.pbb.dao.impl.AccountDaoImpl;
import cn.pbb.factory.BeanFactory;
import cn.pbb.service.IAccountService;

/**
 * @author: pbb
 * @date: 2020/7/6 21:25
 * 业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    private IAccountDao iAccountDao = (IAccountDao) BeanFactory.getBean("accountDao");

    public void saveAccount() {
        iAccountDao.saveAccount();
    }
}
