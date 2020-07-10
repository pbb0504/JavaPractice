package cn.pbb.factory;

import cn.pbb.service.IAccountService;
import cn.pbb.service.impl.AccountServiceImpl;

/**
 * @author: pbb
 * @date: 2020/7/10 13:33
 * 模拟一个工厂类，该类可能存在于jar包中，无法通过修改源码的方式来提供默认构造函数
 */
public class StaticFactory {
    public static IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
