package cn.pbb.factory;

import cn.pbb.domain.Account;
import cn.pbb.service.IAccountService;
import cn.pbb.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: pbb
 * @date: 2020/7/15 20:30
 */
public class BeanFactory {
    private IAccountService iAccountService;
    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public final void setiAccountService(IAccountService iAccountService) {
        this.iAccountService = iAccountService;
    }

    /**
     * get proxy object
     * 以后所有spring自动生成的accountService都经过此增强
     *
     * @return
     */
    public IAccountService getiAccountService() {
        return (IAccountService) Proxy.newProxyInstance(iAccountService.getClass().getClassLoader(),
                iAccountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 环绕通知
                     * 在环绕通知中有明确的切入点方法调用
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if("test".equals(method.getName())){
                           return method.invoke(iAccountService,args);
                        }
                        Object res;
                        try {
                            // open transaction   前置通知
                            transactionManager.beginTransaction();
                            // execute transaction
                            // 执行accountService接口中的方法
                            res = method.invoke(iAccountService, args);
                            // commit   后置通知
                            transactionManager.commit();
                            // return result
                            return res;
                        } catch (Exception e) {
                            // 异常通知
                            transactionManager.rollback();
                            e.printStackTrace();
                            // rollback
                        } finally {
                            // close   最终通知
                            transactionManager.release();
                        }
                        return null;
                    }
                });
    }
}

