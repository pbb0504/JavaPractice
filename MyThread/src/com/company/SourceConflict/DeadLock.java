package com.company.SourceConflict;

public class DeadLock {
    public static void main(String[] args) {
        // 死锁：多个对象彼此持有对方的锁而不做释放
        Runnable runnable1=() ->{
            synchronized ("A"){
                System.out.println("A线程持有了A锁");

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
                }
            }
        };

        Thread A=new Thread(runnable1,"A");
        Thread B=new Thread(runnable2,"B");

        A.start();
        B.start();
    }
}
