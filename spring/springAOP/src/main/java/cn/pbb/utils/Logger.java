package cn.pbb.utils;

/**
 * @author: pbb
 * @date: 2020/7/17 14:26
 */
public class Logger {

    /**
     * print log  并且让其在切入点方法执行之前执行（切入点方法：业务层方法）
     */
    public void printLog(){
        System.out.println("log printing......");
    }
}
