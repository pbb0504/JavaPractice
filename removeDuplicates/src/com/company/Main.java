package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = new int[10];
        nums[0] = 0;
        nums[1] = 0;
        nums[2] = 1;
        nums[3] = 1;
        nums[4] = 1;
        nums[5] = 2;
        nums[6] = 2;
        nums[7] = 3;
        nums[8] = 3;
        nums[9] = 4;
        System.out.println(removeDuplicates(nums));
    }
     static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }






    static int pra(int[] nums){
        if(nums.length == 0){
            return 0;
        }
        int i = 0;
        for(int j = 1; j<nums.length ;j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
