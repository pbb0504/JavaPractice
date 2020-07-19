package cn.pbb.service.impl;

import cn.pbb.service.IAccountService;

/**
 * @author: pbb
 * @date: 2020/7/17 14:24
 */
public class AccountServiceImpl implements IAccountService {

    @Override
    public void saveAccount() {
        System.out.println("saved");
    }

    @Override
    public void updateAccount(int id) {
        System.out.println("updated");
    }

    @Override
    public int deleteAccount() {
        System.out.println("deleted");
        return 0;
    }
}
