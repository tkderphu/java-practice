package leetcode;

public class Leet_6_Zigzag_Conversion {
    /**
     * My solution
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        int row = numRows;
        int col = s.length();
        int[][] matrix = new int[row][col];
        /**
         * Fill position i, j = -1
         */
        for(int i =0 ;i < row; i++) {
            for(int j = 0; j < col; j++) {
                matrix[i][j] = -1;
            }
        }

        int p = 0;
        int cRow = 0;
        int cCol = 0;
        boolean checkStart = true;
        while(p < s.length()) {
            if(checkStart) {
                matrix[cRow][cCol] = p;
                if(cRow == numRows - 1) {
                    cRow --;
                    cCol += 1;
                    checkStart = false;
                } else {
                    cRow ++;
                }
            } else {
                if(cRow == 0) {
                    checkStart = true;
                    continue;
                }
               matrix[cRow][cCol] = p;
               cRow --;
               cCol++;

            }
            p++;
        }
        StringBuilder res = new StringBuilder();
        for(int i =0 ;i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(matrix[i][j] != -1) {
                    res.append(s.charAt(matrix[i][j]));
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        convert("PAYPALISHIRING", 3);
    }
}
