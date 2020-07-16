package com.company;

/**
 * @author: pbb
 * @date: 2020/7/16 10:33
 */
public class MyThread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            if (i == 3) {
                Thread.yield();
            }
        }
    }
}
