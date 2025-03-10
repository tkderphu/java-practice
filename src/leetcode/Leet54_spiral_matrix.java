package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leet54_spiral_matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int r = 0;
        int c = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int length = n * m;
        while(list.size() < length) {
            for(int i = c; i < m; i++) {
                list.add(matrix[r][i]);
            }
            if(list.size() == length) break;
            r ++;
            for(int i = r; i < n; i++) {
                list.add(matrix[i][m - 1]);
            }
            if(list.size() == length) break;

            m --;
            for(int i = m - 1; i >= c; i --) {
                list.add(matrix[n - 1][i]);
            }
            if(list.size() == length) break;

            n --;
            for(int i = n - 1; i >= r; i--) {
                list.add(matrix[i][c]);
            }
            if(list.size() == length) break;

            c ++;
        }

        return list;
    }

    public static void main(String[] args) {
        new Leet54_spiral_matrix().spiralOrder(new int[][]{
                {1,2,3, 4}, {5,6, 7, 8}, {9, 10, 11, 12}
        });
    }
}
