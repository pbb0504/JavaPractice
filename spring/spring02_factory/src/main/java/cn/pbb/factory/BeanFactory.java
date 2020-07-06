package cn.pbb.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author: pbb
 * @date: 2020/7/6 21:36
 * 一个创建Bean对象的工厂
 * Bean：
 * 可重用组件
 * JavaBean：用java语言编写的可重用组件
 * javabean>实体类
 * <p>
 * 创建service和dao对象的
 * 1. 需要一个配置文件来配置service和dao
 * 配置文件：唯一标识=全限定类名（key，value） xml,properties
 * 2. 通过读取配置文件中的内容，反射创建对象
 */
public class BeanFactory {
    // 定义一个properties对象
    private static Properties properties;

    // 使用静态代码块为properties赋值
    static {
        try {
            // 实例化对象
            properties = new Properties();
            // 获取properties文件的流对象
            InputStream inputStream = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            properties.load(inputStream);
        } catch (IOException e) {
           throw new ExceptionInInitializerError("初始化properties失败");
        }
    }

    /**
     * 根据bean的名称获取bean对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {
        Object bean = null;
        try {
            String beanPath = properties.getProperty(beanName);
            bean = Class.forName(beanPath).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
