package cn.pbb.ui;


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
        // 获取核心容器对象
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        // 根据id获取bean对象
        IAccountService iAccountService = (IAccountService) applicationContext.getBean("accountService");
        iAccountService.saveAccount();

        // 手动关闭容器
        applicationContext.close();
    }
}
