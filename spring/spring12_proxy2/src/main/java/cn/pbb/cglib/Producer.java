package cn.pbb.cglib;

import cn.pbb.proxy.IProducer;

/**
 * @author: pbb
 * @date: 2020/7/14 15:43
 */
public class Producer{
    /**
     * sell
     * @param money pay
     */

    public void sellProduct(Float money) {
        System.out.println("sell and get " + money);
    }

    /**
     * after sell
     * @param money pay
     */

    public void afterService(Float money) {
        System.out.println("service and get " + money);
    }
}
