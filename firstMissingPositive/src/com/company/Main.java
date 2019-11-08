package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    static int firstMissingPositive(int[] nums){
        int now = 0;
        int next = 0;
        int[] nums2 = new int[nums.length];
        for(int n = 0; n<nums.length; n++){
            // 小于等于0的数跳过
            // 剩下的都为正整数，是否匹配从1开始的自然数序列
            if(nums[n] >= 1){

            }
        }
        return 0;
    }
}
