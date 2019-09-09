package com.company.SourceConflict;

public class SynchronizedDemo {
    // 同步代码段
    public static void main(String[] args) {
        Runnable r = () -> {
            while (TicketCenter.restCount > 0) {
                // 同步代码段
                // 对象锁
                // 类锁
                // 多个线程看到的必须是同一把锁
                synchronized (SynchronizedDemo.class){
                    if(TicketCenter.restCount<=0){
                        return;
                    }
                    System.out.println(Thread.currentThread().getName() +
                            "卖出了一张票,还剩" + --TicketCenter.restCount + "张票");
                }
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
