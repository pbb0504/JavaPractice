package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String s = "12345678";
        scroll(s);
    }

    static void scroll(String s) {
        int windowSize = 5;
        char[] chars = s.toCharArray();
        int currentIndex = 0;
        // 显示12345,23456,34567,45678
        while ((currentIndex + windowSize - 1) < chars.length) {
            for (int i = currentIndex; i < currentIndex + windowSize; i++) {
                System.out.print(chars[i]);
            }
            System.out.println();
            currentIndex++;
            if ((currentIndex + windowSize - 1) >= chars.length){
                currentIndex = 0;
            }
        }
    }
}
