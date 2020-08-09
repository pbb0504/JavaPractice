package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums={4,1,2,1,2};
        System.out.println(new Main().singleNumber(nums));
    }
    public int singleNumber(int[] nums){
        int result=0;
        for(int i : nums){
            result^=i;
        }
        return result;
    }
}
