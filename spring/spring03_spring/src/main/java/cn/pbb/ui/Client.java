package cn.pbb.ui;

import cn.pbb.dao.IAccountDao;
import cn.pbb.service.IAccountService;
import cn.pbb.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author: pbb
 * @date: 2020/7/6 21:30
 * 模拟表现层，用于调用业务层
 */
public class Client {
    /**
     * 获取spring容器Ioc核心容器，并根据id获取对象
     * applicationContext三个常用实现类
     * 1. ClassPathXmlApplicationContext 加载类路径下的配置文件，要求配置文件必须在类路径下，不在的话，加载不了
     * 2. FileSystemXmlApplicationContext 加载磁盘任意路径下的配置文件（必须有访问权限）
     * 3. AnnotationConfigApplicationContext 用于读取注解创建容器
     *
     *
     * 核心容器的两个接口引发的问题
     * ApplicationContext:单例对象适用
     *      他在构建核心容器时，创建对象采取的时采用立即加载的方式，只要一读取完配置文件马上就创建配置文件中配置的对象
     * BeanFactory:多例对象适用
     *      它在构建核心容器时，创建对象采取的方式是延迟加载的方式，什么时候根据id获取对象，什么时候才真正地获取对象
     * @param args
     */
    public static void main(String[] args) {
        // 获取核心容器对象
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //FileSystemXmlApplicationContext applicationContext = new FileSystemXmlApplicationContext("D:\\ideaProjects\\spring03_spring\\src\\main\\resources\\bean.xml");
        // 根据id获取bean对象
        // IAccountService iAccountService = (IAccountService) applicationContext.getBean("accountService");

        // IAccountDao iAccountDao = applicationContext.getBean("accountDao", IAccountDao.class);

        // System.out.println(iAccountService);
        // System.out.println(iAccountDao);
        //iAccountService.saveAccount();


        // BeanFactory
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory bf = new XmlBeanFactory(resource);
        IAccountService iAccountService = (IAccountService) bf.getBean("accountService");
        System.out.println(iAccountService);
    }
}
