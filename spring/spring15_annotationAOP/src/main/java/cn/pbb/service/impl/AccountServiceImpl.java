package cn.pbb.service.impl;

import cn.pbb.service.IAccountService;
import org.springframework.stereotype.Service;

/**
 * @author: pbb
 * @date: 2020/7/17 14:24
 */
@Service("accountService")
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
