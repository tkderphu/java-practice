package code_ptit.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Matrix {
    private int row;
    private int col;
    private int[][] matrix;
    public Matrix(int numRow, int numCol) {
        this.row = numRow;
        this.col = numCol;
        matrix = new int[100][100];
    }

    public void setPosition(int row, int col, int data) {
        matrix[row][col] = data;
    }

    public void sort(int col) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < row; i++) {
            list.add(matrix[i][col]);
        }
        Collections.sort(list);
        for(int i = 0; i < row; i++) {
            matrix[i][col] = list.get(i);
        }
    }

    @Override
    public String toString() {
        String result = "";
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                result += matrix[i][j] + " ";
            }
            result += "\n";
        }
        return result;
    }
}
