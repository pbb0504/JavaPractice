package cn.pbb.service.impl;

import cn.pbb.dao.IAccountDao;
import cn.pbb.domain.Account;
import cn.pbb.service.IAccountService;
import cn.pbb.utils.TransactionManager;

import java.util.List;

/**
 * @author: pbb
 * @date: 2020/7/12 11:15
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao iAccountDao;

    public void setiAccountDao(IAccountDao iAccountDao) {
        this.iAccountDao = iAccountDao;
    }

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

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        Account sourceAccount = iAccountDao.findAccountByName(sourceName);
        Account targetAccount = iAccountDao.findAccountByName(targetName);
        sourceAccount.setMoney(sourceAccount.getMoney() - money);
        targetAccount.setMoney(targetAccount.getMoney() + money);
        iAccountDao.updateAccount(sourceAccount);
        iAccountDao.updateAccount(targetAccount);
    }

    @Override
    public void test() {
        System.out.println("hhhhhhhh");
    }
}
