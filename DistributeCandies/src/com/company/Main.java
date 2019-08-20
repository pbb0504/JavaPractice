package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] arr = {1, 0, 1, 0, 1, 0, 1};
        System.out.println(new Main().distributeCandies2(arr));
    }

    public int distributeCandies(int[] candies) {
        // 从头开始遍历碰到不同种类就添加，直到最后,如果没满，就说明最多这么多种类
        int length = 1;
        //List<Integer> old=new ArrayList<>();// 这样会超出时间限制
        //old.add(pre);
        Arrays.sort(candies);
        int pre = candies[0];
        for (int i = 1; i < candies.length; i++) {
            //if(!old.contains(candies[i]))
            if (candies[i] != pre) {
                length++;
                pre = candies[i];
            }
            //old.add(candies[i]);
        }
        // 这里要限制个数
        return Math.min(length, candies.length / 2);
    }
    public int distributeCandies2(int[] candies){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i : candies) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        boolean[] type = new boolean[max - min + 1];// 默认全为false,即还未出现过
        int ans = 0;
        for(int i : candies) {
            if(!type[i - min]) {// i-min即为i在type中的位置，这里if表示未出现过时进入循环
                ans++;
                if(ans >= candies.length / 2) {
                    return ans;//种类数超过半数即到达妹妹可拥有糖果数上限
                }
                type[i - min] = true;// 出现过
            }
        }
        return ans;
    }
}