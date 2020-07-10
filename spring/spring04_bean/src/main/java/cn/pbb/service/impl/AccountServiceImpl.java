package cn.pbb.service.impl;

import cn.pbb.service.IAccountService;

/**
 * @author: pbb
 * @date: 2020/7/6 21:25
 * 业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    public AccountServiceImpl(){
        System.out.println("object created");
    }
    public void init() {
        System.out.println("service初始化");
    }
    public void saveAccount() {
        System.out.println("service中的saveAccount执行了");
    }
    public void destroy() {
        System.out.println("service销毁");
    }
}
