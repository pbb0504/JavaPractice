package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] nums = {1, 3};
        int target = 2;
        int res = new Main().searchInsert2(nums, target);
        int res2 = new Main().searchInsert(nums, target);
        System.out.println(res);
        System.out.println(res2);
    }

    /**
     * @param nums 数组
     * @param target 插入值
     * @return 下标
     */
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return length;
    }

    /**
     * 使用二分法查找
     *
     * @param nums 数组
     * @param target 插入值
     * @return 下标
     */
    public int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;// mid一直在变
            if (nums[mid] == target) {
                return mid;
            } else {
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return left;
    }
}
