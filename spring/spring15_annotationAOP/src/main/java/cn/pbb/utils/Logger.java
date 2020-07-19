package cn.pbb.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author: pbb
 * @date: 2020/7/17 14:26
 */
@Component("logger")
@Aspect
public class Logger {

    @Pointcut("execution(* cn.pbb.service.impl.*.*(..))")
    private void pt1(){};

    /**
     * print log  并且让其在切入点方法执行之前执行（切入点方法：业务层方法）
     * 前置通知
     */
    @Before("pt1()")
    public void beforePrintLog() {
        System.out.println("before log printing......");
    }

    /**
     * 后置通知
     */
    @After("pt1()")
    public void afterPrintLog() {
        System.out.println("after log printing......");
    }

    /**
     * 异常通知
     */
    @AfterThrowing("pt1()")
    public void exceptionPrintLog() {
        System.out.println("exceptionPrintLog log printing......");
    }


    /**
     * 返回通知
     */
    @AfterReturning("pt1()")
    public void returnPrintLog() {
        System.out.println("return log printing......");
    }

    /**
     * 环绕通知
     * 问题： 当我们配置了环绕通知之后，切入点方法没有执行，而通知方法执行了
     * 分析：
     * 通过对比动态代理中的环绕通知代码，发现动态代理中的环绕通知有明确的切入点方法调用，而
     * 此处没有，所以只打印了一句
     * 解决：
     * spring提供了接口，ProceedingJoinPoint 该接口有一个方法 proceed() 相当于明确调用切入点方法
     * 该接口可以作为环绕通知的方法参数，在程序执行时，spring框架会为我们提供该接口的实现类来供我们使用
     *
     * 它是spring为我们提供的一种可以在代码中手动控制增强方法何时执行的方式
     */
    @Around("pt1()")
    public Object aroundPrintLog(ProceedingJoinPoint joinPoint) {
        // 明确调用切入点方法
        try {
            Object[] args = joinPoint.getArgs();
            System.out.println("around log printing......before");
            Object proceed = joinPoint.proceed(args);
            System.out.println("around log printing......after");
            return proceed;
        } catch (Throwable throwable) {
            System.out.println("around log printing......throw");
            throwable.printStackTrace();
        } finally {
            System.out.println("around log printing......return");
        }
        return null;
    }
}
