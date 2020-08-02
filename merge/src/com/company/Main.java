package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 13053
 */
public class Main {

    public static void main(String[] args) {
        // write your code here
        // 0,5
        int[][] intervals = {{0, 1}, {1, 2}, {2, 4}, {3, 5}};
        intervals = new Main().merge(intervals);
        for (int[] interval : intervals) {
            System.out.print("[");
            for (int i : interval) {
                System.out.print(i);
            }
            System.out.print("]");
        }
    }

    int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length <=1){
            return intervals;
        }
        // 让每个一维数组的第一个元素按大小排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        // 用来存放合并后的一维数组
        List<int[]> list = new ArrayList<>();
        // 存放第一个一维数组的左右两个元素
        int left = intervals[0][0];
        int right = intervals[0][1];
        // 遍历数组
        for (int[] interval : intervals) {
            // 如果后面数组的左侧大于左面数组的右侧 说明左面数组合并（或不需要合并）结束 加入list
            if(interval[0] > right){
                list.add(new int[]{left,right});
                // 现在前面已成往事，开始后面的合并
                left = interval[0];
                right = interval[1];
            }else{
                // 为什么使用min和max [3,8] [4,5]
                left = Math.min(interval[0],left);
                right = Math.max(interval[1],right);
            }
        }
        // 若需一路合并，在此加入list
        list.add(new int[]{left,right});
        int size = list.size();
        int[][] merge = new int[size][2];
        for(int i = 0; i < size; i++){
            merge[i] = list.get(i);
        }
        return merge;
    }
}
