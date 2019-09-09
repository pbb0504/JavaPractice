package com.company.SourceConflict;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String[] args) {
        /**
         * 实例化一个锁对象
         */
        // 显式锁
        ReentrantLock lock = new ReentrantLock();
        Runnable r = () -> {
            while (TicketCenter.restCount > 0) {
                // 对临界资源上锁
                lock.lock();
                if (TicketCenter.restCount <= 0) {
                    return;
                }
                System.out.println(Thread.currentThread().getName() +
                        "卖出了一张票,还剩" + --TicketCenter.restCount + "张票");
                // 对临界资源解锁
                lock.unlock();
            }
        };
        Thread thread1 = new Thread(r, "Thread1");
        Thread thread2 = new Thread(r, "Thread2");
        Thread thread3 = new Thread(r, "Thread3");
        Thread thread4 = new Thread(r, "Thread4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
