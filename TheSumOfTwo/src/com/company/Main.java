package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Main main=new Main();
        int[] nums={1,2,3};
        for(int i :main.twoSum(nums,3)){
            System.out.println(i);
        }
    }
    public int[] twoSum(int[] nums, int target) {
        int[] results=new int[2];
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if((nums[i]+nums[j])==target){
                    results[0]=i;
                    results[1]=j;
                    return results;
                }else continue;
            }
        }
        System.out.println("未找到结果");
        return null;
    }
}
