package com.company.exercises;


public class Exercise5 {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            while(true){
            System.out.println(Thread.currentThread().getName()+": "+Math.random());
            if(Math.random() < 0.5)
                break;
            }
        };
        Thread thread = new Thread(runnable,"1");
        Thread thread1 = new Thread(runnable,"2");
        thread.start();
        thread1.start();
    }
}
