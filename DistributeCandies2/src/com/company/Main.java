package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int res[]=new Main().distributeCandies(10,3);
        for(int i : res)
            System.out.print(i+",");
    }

    public int[] distributeCandies(int candies, int num_people) {
        int num = 1;
        int[] numbs = new int[num_people];
        for (int n : numbs)
            n = 0;
        while(candies!=0)
        for (int i = 0; i < num_people; i++) {// 循环一遍
            //if(candies==0) return numbs; 这样就不能再从头发一遍了
            numbs[i] += num;// 获得糖果
            candies -= num;// 从总数中减去
            if (candies <= num)// 剩余数目不足,此时即使再进行循环给后面的人都是0个糖果，
                num = candies;//而顶多循环完这一遍就能发现剩余数目不足
            else
                num++;
        }
        return numbs;
    }
}