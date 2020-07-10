package cn.pbb.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
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
    // 定义一个Map，用于存放我们要存放的对象，把它称之为容器
    private static Map<String, Object> beans;

    // 使用静态代码块为properties赋值
    static {
        try {
            // 实例化对象
            properties = new Properties();
            // 获取properties文件的流对象
            InputStream inputStream = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            properties.load(inputStream);
            // 实例化容器
            beans = new HashMap<String, Object>();
            // 取出配置文件中所有的key
            Enumeration keys = properties.keys();
            // 遍历枚举
            while (keys.hasMoreElements()) {
                String key = keys.nextElement().toString();
                // 根据key获取value;
                String beanPath = (String) properties.get(key);
                Object value = Class.forName(beanPath).newInstance();
                // 这里已经根据不同的beanPath存好了对象
                beans.put(key, value);
            }
        } catch (IOException e) {
            throw new ExceptionInInitializerError("初始化properties失败");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据bean的名称获取bean对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {
        return beans.get(beanName);
    }




    /**
     * 根据bean的名称获取bean对象
     *
     * @param beanName
     * @return
     */
   /* public static Object getBean(String beanName) {
        Object bean = null;
        try {
            String beanPath = properties.getProperty(beanName);
            // 每次调用默认构造函数创建对象
            bean = Class.forName(beanPath).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return bean;
    }*/
}
