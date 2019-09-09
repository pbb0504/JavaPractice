package com.company.SourceConflict;

public class SourceConflict {
    // 四个售票员买票
    public static void main(String[] args) {
        Runnable r = () -> {
            while(TicketCenter.restCount>0){
                System.out.println(Thread.currentThread().getName()+
                        "卖出了一张票,还剩"+ --TicketCenter.restCount +"张票");
            }
        };
        Thread thread1=new Thread(r,"Thread1");
        Thread thread2=new Thread(r,"Thread2");
        Thread thread3=new Thread(r,"Thread3");
        Thread thread4=new Thread(r,"Thread4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }
}

class TicketCenter{
    public static int restCount=100;
}
