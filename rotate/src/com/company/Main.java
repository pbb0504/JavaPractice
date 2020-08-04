package com.company;

/**
 * @author 13053
 */
public class Main {

    public static void main(String[] args) {
        // write your code here
    }

    /**
     * [1,2,3],
     * [4,5,6],
     * [7,8,9]
     * <p>
     * <p>
     * [7,4,1],
     * [8,5,2],
     * [9,6,3]
     *
     * @param matrix 矩阵
     */
    public void rotate(int[][] matrix) {
        // 不同边长（奇偶性）的矩阵处理方式不同
        /* 对于奇数边长矩阵
            1. 角：左上角：行不变  列加上length-1
                  右上角：列不变  行加上length-1
                  右下角：行不变  列减去length-1
                  左下角：列不变  行减去length-1

             无需  无需如此
             先进行对称，即得到每一行排列相反的矩阵，再对每一行相对位置（以中心元素对称）元素的交换
         */
        /*
            1,2,3
            4

            1,6,3
            4

            1,6,3
            2

            1,4,3
            2
         */
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                matrix[i][j] = matrix[i][j] + matrix[j][i];
                matrix[j][i] = matrix[i][j] - matrix[j][i];
                matrix[i][j] = matrix[i][j] - matrix[j][i];
            }
        }

        /*
            1,2,3

            4,2,3

            4,2,1

            3,2,1
         */
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <= matrix.length / 2 - 1; j++) {
                // 小于等于长度/2-1
                matrix[i][j] = matrix[i][matrix.length - j - 1] + matrix[i][j];
                matrix[i][matrix.length - j - 1] = matrix[i][j] - matrix[i][matrix.length - j - 1];
                matrix[i][j] = matrix[i][j] - matrix[i][matrix.length - j - 1];
            }
        }
    }
}
