package cn.pbb.ui;


import cn.pbb.dao.IAccountDao;
import cn.pbb.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: pbb
 * @date: 2020/7/6 21:30
 * 模拟表现层，用于调用业务层
 */
public class Client {
    /**
     * @param args
     */
    public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService iAccountService = (IAccountService) applicationContext.getBean("accountService");
//        IAccountService iAccountService2 = (IAccountService) applicationContext.getBean("accountService");

       /* IAccountDao iAccountDao = (IAccountDao) applicationContext.getBean("accountDao");
        System.out.println(iAccountService);
        System.out.println(iAccountDao);*/
        iAccountService.saveAccount();
//        System.out.println(iAccountService == iAccountService2);
        applicationContext.close();
    }
}
