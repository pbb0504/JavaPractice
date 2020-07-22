package com.company.strictfpTest;

/**
 * @author: pbb
 * @date: 2020/7/22 13:58
 */
public class StrictfpTest {
    public static void main(String[] args) {
        // 3.142857142857143 with strictfp
        double a = 22.0/7;
        // 3.142857142857143 without strictfp
        double b = 22.0/7;
        // 此处没指定22或7为浮点数 则先计算为int类型再转为float类型
        float c = 22/7;
        System.out.println(c);
    }
}
