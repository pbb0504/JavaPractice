package cn.pbb.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

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
         *      基于子类的动态代理
         *          涉及的类：Enhancer
         *          提供者：第三方cglib库
         *          如何创建代理对象：
         *              使用Enhancer类中create方法
         *          创建代理对象的要求：
         *              被代理类不能是最终类
         *          create方法参数
         *              Class: 字节码
         *                  用于指定被代理对象的字节码
         *              Callback:用于提供增强
         *              一般写该接口的子接口实现类:MethodInterceptor
         *
         *
         *
         *      基于子类的动态代理
         */
        Producer producer1 = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             * 执行被代理对象的任何方法都会经过此方法
             * @param o proxy
             * @param method method
             * @param objects args
            以上三个参数和基于接口的动态代理中invoke方法的参数是一样的
             * @param methodProxy 当前执行方法的代理对象
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object returnValue = null;
                // 拦截到的方法的参数
                Float money = (Float) objects[0];
                // 如果拦截到的方法是"sellProduct"
                // producer.sellProduct(money)
                if ("sellProduct".equals(method.getName())) {
                    returnValue = method.invoke(producer, money * 0.8f);
                }
                return returnValue;
            }
        });
        producer1.sellProduct(12000f);
    }
}
