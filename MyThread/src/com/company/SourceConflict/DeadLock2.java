package com.company.SourceConflict;

public class DeadLock2 {
    public static void main(String[] args) {
        // 等待：Object类中的方法，令当前的线程释放自己的锁标记，让出CPU资源，进入等待队列
        // 唤醒：Object类中的方法，唤醒等待队列中的线程，使线程进入锁池
        // notifyAll: Object类中的方法，唤醒等待队列中所有等待x锁的线程，并使这些线程进入锁池
        Runnable runnable1=() ->{
            synchronized ("A"){
                System.out.println("A线程持有了A锁");
                // A释放已经取得的锁
                try {
                    "A".wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized ("B"){
                    System.out.println("A线程同时持有了B锁");
                }
            }
        };

        Runnable runnable2=()->{
            synchronized ("B"){
                System.out.println("B线程持有了B锁");

                synchronized ("A"){
                    System.out.println("B线程同时持有了A锁");
                    // 唤醒等待A锁的线程
                    "A".notifyAll();
                }
            }
        };

        Thread A=new Thread(runnable1,"A");
        Thread B=new Thread(runnable2,"B");

        A.start();
        B.start();
    }
}
