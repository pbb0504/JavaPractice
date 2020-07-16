package com.company;

/**
 * @author 13053
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        MyThread2 thread2 = new MyThread2();
        MyThread2 thread = new MyThread2();
        thread.run();
        thread2.run();
    }
}
