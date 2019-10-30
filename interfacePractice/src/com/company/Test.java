package com.company;

public class Test {
    public static void main(String[] args) {
        findNum();
    }

    static void findNum() {
        for (int num = 1; num < 1001; num++) {
            // 找出num的所有因子
            int sum = 0;
            for (int x = 1; x < num; x++) {
                if (num % x == 0) {
                    // 计入和中
                    sum += x;
                }
            }
            if (sum == num){
                System.out.println(num);
            }
        }
    }
}
