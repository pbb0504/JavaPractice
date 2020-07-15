package cn.pbb.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: pbb
 * @date: 2020/7/14 15:47
 */
public class Client {
    public static void main(String[] args) {
        final Producer producer = new Producer();

        /**
         * 动态代理  字节码随用随创建，随用随加载
         * 不修改源码的基础上，对方法增强
         * 分类：
         *      基于接口的动态代理
         *          涉及的类：proxy
         *          提供者：JDK官方
         *          如何创建代理对象：
         *              使用newProxyInstance
         *          创建代理对象的要求：
         *              被代理类至少实现一个接口
         *          newProxyInstance参数
         *              ClassLoader:类加载器
         *                  他是用于加载代理对象字节码的，和被代理对象使用相同的类加载器。固定写法
         *              Class[]: 字节码数组
         *                  让代理对象和被代理对象有相同的方法。固定写法
         *              InvocationHandler:用于提供增强的代码
         *                  让我们写如何代理，我们一般都是写一个该接口的实现类，通常情况下都是匿名内部类，但不是必须的
         *                  此接口的实现类都是谁用谁写
         *      基于子类的动态代理
         */
        Proxy.newProxyInstance(Producer.class.getClassLoader(),
                Producer.class.getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 执行被代理对象的任何接口方法都会经过该方法
                     * @param proxy 代理对象的引用
                     * @param method 当前执行的方法
                     * @param args 当前执行方法所需的参数
                     * @return 和被代理对象方法有相同的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object returnValue = null;
//                        获取方法执行的参数
                        Float money = (Float) args[0];
                        // 判断当前方法是不是销售
                        if ("sellProduct".equals(method.getName())) {
                            returnValue = method.invoke(producer, money * 0.8);
                        }
                        return returnValue;
                    }
                });
        producer.sellProduct(10000f);
    }
}
