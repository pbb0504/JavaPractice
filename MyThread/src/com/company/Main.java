package com.company;

import java.sql.SQLSyntaxErrorException;

public class Main {
    public static void main(String[] args) {
        threadYield();
    }
    /**
     * 线程的礼让
     */
    private  static  void  threadYield(){
        // 线程的礼让指的是，正在运行态的线程放弃自己的CPU时间片，由运行态返回就绪态
        Runnable r=new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    System.out.println(Thread.currentThread().getName()+": "+i);
                    if(i==3){
                        Thread.yield();
                    }
                }
            }
        };

        Thread thread1=new Thread(r,"thread1");
        Thread thread2=new Thread(r,"thread2");

        thread1.start();
        thread2.start();
    }
    /**
     *设置线程优先级
     */
    private static void threadPriority(){
        // 设置线程的优先级，只是提高此线程抢到CPU时间片的概率
        // 并不意味着能一定抢到CPU时间片
        // 优先级的设置是一个（0，10）的整数，默认是5
        Runnable r= () ->{
            // 这里是run()的内容
           for(int i=0;i<10;i++){
               System.out.println(Thread.currentThread().getName()+": "+i);
           }
        };
        Thread thread1=new Thread(r);
        Thread thread2=new Thread(r);

        //设置优先级必须在线程start之前
        thread1.setPriority(10);
        thread2.setPriority(8);

        thread1.start();
        thread2.start();
    }
    /**
    线程的休眠
     */
    private static void threadSleep() {
        MyThread thread=new MyThread("custom");
        thread.start();
    }
    /**
     * 线程的命名
     */
    private static void threadName(){
        MyThread myThread = new MyThread();
        myThread.start();
        myThread.run();
        System.out.println("主线程执行结束");

        // 通过Runnable接口
        Runnable r1 = () -> {
            for (int i = 0; i < 4; i++) {
                System.out.println("线程2：" + i);
            }
        };
        Thread t2 = new Thread(r1);
        t2.start();

        Thread t=new MyThread();
        t.setName("custom");

        /*
        通过构造方法，实例化线程
        Thread(Runnable r,String name)
         */
         Thread t3=new Thread(()->{},"custom");

         //3.使用自定义的线程类实例化线程对象并赋名字，通过继承Thread类
        MyThread t4=new MyThread("custom");
        System.out.println(t.getName());
    }
}

/**
 MyThread继承Thread类
 */
class MyThread extends Thread {
    //@Override
    //public void run() {
    //    for (int i = 0; i < 10; i++) {
    //        System.out.println("MyThread1" + i);
    //    }
    //}
    MyThread(){    }
    MyThread(String name){
        //super(name);
        this.setName(name);
    }

    @Override
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println(i);
            // 线程休眠
            // 1.参数 以毫秒为单位的时间差
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}