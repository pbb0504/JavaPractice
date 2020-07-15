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
public class AccountServiceImpl_Old implements IAccountService {

    private IAccountDao iAccountDao;

    private TransactionManager transactionManager;


    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }


    public void setiAccountDao(IAccountDao iAccountDao) {
        this.iAccountDao = iAccountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        try {
            // open transaction
            transactionManager.beginTransaction();
            // execute transaction
            List<Account> accounts = iAccountDao.findAllAccount();
            // commit
            transactionManager.commit();
            // return result
            return accounts;
        } catch (Exception e) {
            transactionManager.rollback();
            e.printStackTrace();
            // rollback

        } finally {
            // close
            transactionManager.release();
        }
        return null;
    }

    @Override
    public Account findAccountById(Integer id) {
        try {
            // open transaction
            transactionManager.beginTransaction();
            // execute transaction
            Account account = iAccountDao.findAccountById(id);
            // commit
            transactionManager.commit();
            // return result
            return account;
        } catch (Exception e) {
            transactionManager.rollback();
            e.printStackTrace();
            // rollback

        } finally {
            // close
            transactionManager.release();
        }
        return null;
    }

    @Override
    public void saveAccount(Account account) {
        try {
            // open transaction
            transactionManager.beginTransaction();
            // execute transaction
            iAccountDao.saveAccount(account);
            // commit
            transactionManager.commit();
            // return result
        } catch (Exception e) {
            transactionManager.rollback();
            e.printStackTrace();
            // rollback

        } finally {
            // close
            transactionManager.release();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            // open transaction
            transactionManager.beginTransaction();
            // execute transaction
            iAccountDao.updateAccount(account);
            // commit
            transactionManager.commit();
            // return result
        } catch (Exception e) {
            transactionManager.rollback();
            e.printStackTrace();
            // rollback

        } finally {
            // close
            transactionManager.release();
        }
    }

    @Override
    public void deleteAccount(Integer id) {
        try {
            // open transaction
            transactionManager.beginTransaction();
            // execute transaction
            iAccountDao.deleteAccount(id);
            // commit
            transactionManager.commit();
            // return result
        } catch (Exception e) {
            transactionManager.rollback();
            e.printStackTrace();
            // rollback

        } finally {
            // close
            transactionManager.release();
        }
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        try {
            // open transaction
            transactionManager.beginTransaction();
            // execute transaction
            Account sourceAccount = iAccountDao.findAccountByName(sourceName);
            Account targetAccount = iAccountDao.findAccountByName(targetName);
            sourceAccount.setMoney(sourceAccount.getMoney() - money);
            targetAccount.setMoney(targetAccount.getMoney() + money);
            iAccountDao.updateAccount(sourceAccount);
            int i = 1/0;
            iAccountDao.updateAccount(targetAccount);
            // commit
            transactionManager.commit();
            // return result
        } catch (Exception e) {
            transactionManager.rollback();
            e.printStackTrace();
            // rollback
        } finally {
            // close
            transactionManager.release();
        }
    }
}
