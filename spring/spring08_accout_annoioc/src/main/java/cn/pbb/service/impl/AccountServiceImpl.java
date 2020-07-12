package cn.pbb.service.impl;

import cn.pbb.dao.IAccountDao;
import cn.pbb.domain.Account;
import cn.pbb.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: pbb
 * @date: 2020/7/12 11:15
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao iAccountDao;

    @Override
    public List<Account> findAllAccount() {

        return iAccountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer id) {
        return iAccountDao.findAccountById(id);
    }

    @Override
    public void saveAccount(Account account) {
        iAccountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        iAccountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer id) {
        iAccountDao.deleteAccount(id);
    }
}
