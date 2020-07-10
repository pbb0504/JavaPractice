package cn.pbb.ui;

import cn.pbb.factory.BeanFactory;
import cn.pbb.service.IAccountService;
import cn.pbb.service.impl.AccountServiceImpl;

/**
 * @author: pbb
 * @date: 2020/7/6 21:30
 * 模拟表现层，用于调用业务层
 */
public class Client {
    public static void main(String[] args) {
        for(int i =0; i < 5; i++){
            IAccountService iAccountService = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(iAccountService);
        }
        //iAccountService.saveAccount();
    }
}
