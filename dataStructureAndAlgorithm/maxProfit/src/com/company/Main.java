package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] prices = new int[]{1,2,3,4,5,6,9};
        System.out.println(maxProfit(prices));
    }

    static int maxProfit(int[] prices) {
        // 每次循环一次计算收益，更新得到最大
        int maxIncome = 0;
        // 进行多次遍历，前面元素小，后面元素大，大减小，加到maxIncome上
        // 进行几次遍历
        // 最短计算距离为1，最大计算距离为length-1
        int buy = 0;
        // 使用flag判断是否已经买进
        boolean flag = true;
        // int sell = 1;
        int calDistance = 0;
        maxIncome = prices[0];
        int res = 0;
        for (calDistance = 1; calDistance < prices.length; calDistance++) {
           // for (int j = 0; j < prices.length; j++) {
                //buy = j;
                while (buy + calDistance < prices.length){
                    if (flag) {// 如果已经买进
                        if (prices[buy] < prices[buy + calDistance]) {
                            maxIncome += prices[buy + calDistance];
                            flag = false;// 卖出
                            buy += (calDistance + 1);
                        } else {
                            buy += 1;
                        }
                    } else {
                        // 准备买进
                        maxIncome -= prices[buy];
                        flag = true;
                    }
                    res = res>maxIncome?res:maxIncome;
                }
                // }
        }
        return res;
    }


    static int maxProfit2(int[] prices){
        // 先减再加，如果小于等于0，，则不能进行投资
        return 0;
    }
}
