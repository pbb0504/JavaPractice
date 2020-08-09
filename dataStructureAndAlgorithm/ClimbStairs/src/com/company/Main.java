package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println(new Main().climbStairs2(385));
    }

    // 这种方法不好，如果可以一次走n个台阶呢？(此方法舍弃）不过以后可能有用
    // 在此记下想法，两个数字的排列组合：1、2。当1少于2时变为在2中插入1，反之同理
    // 居然就是斐波那契数列  .递归速度太慢,过慢，真的很慢
    // 385已经超出int的范围了。。
    public int climbStairs(int n) {
        if (n <= 1) return 1;
        else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }

    public long climbStairs2(int n) {//int放不下太大的数，用long
        long x = 1;
        long y = 1;
        long z = 1;
        long i = 2;
        long m=0;
        while (i <= n) {// 需要计算这么多次
            z = x + y;
            m=y;
            y=z;
            x=m;
            i++;
        }
        return z;
    }
}