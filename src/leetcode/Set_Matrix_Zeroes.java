package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Set_Matrix_Zeroes {
    class  Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void setZeroes(int[][] matrix) {
        List<Pair> list = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    list.add(new Pair(i, j));
                }
            }
        }
        for(int i = 0; i < list.size(); i++) {
            Pair pair = list.get(i);
            for(int j = 0; j < matrix[pair.y].length; j++) {
                matrix[pair.x][j] = 0;
            }
            for(int j = 0; j < matrix.length; j++) {
                matrix[pair.y][j] = 0;
            }

        }
    }
}
