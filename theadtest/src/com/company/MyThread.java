package com.company;

/**
 * @author: pbb
 * @date: 2020/7/16 10:33
 */
public class MyThread extends Thread {
    int i = 0;
    @Override
    public void run() {
        while (i < 10) {
            System.out.println(i++);
        }
        try {
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
