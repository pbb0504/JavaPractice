import java.util.ArrayList;
import java.util.List;

/**
 * @author: pbb
 * @date: 2020/8/4 12:34
 */
public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{3, 7, 2, 8, 2}, {2, 2, 4, 1, 8}, {0, 5, 7, 6, 3}, {8, 1, 0, 7, 7}, {1, 3, 7, 4, 1}, {6, 5, 5, 6, 3}, {7, 1, 0, 1, 9}, {5, 4, 4, 9, 7}, {2, 2, 4, 1, 0}, {7, 1, 1, 9, 1}, {8, 0, 4, 7, 6}, {7, 5, 1, 2, 3}, {7, 2, 5, 9, 3}};
        new Main().setZeroes(matrix);
    }

    void setZeroes(int[][] matrix) {
        List is = new ArrayList<Integer>();
        List js = new ArrayList<Integer>();
        int n = 2;
        while (n != 0) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (n == 2) {
                        if (matrix[i][j] == 0) {
                            is.add(i);
                            js.add(j);
                        }
                    } else {
                        // 不能用StringBuilder 不然10变成1和0
                        if (is.contains(i)) {
                            matrix[i][j] = 0;
                        }
                        if (js.contains(j)) {
                            matrix[i][j] = 0;
                        }
                    }
                }
            }
            n--;
        }
    }
}
