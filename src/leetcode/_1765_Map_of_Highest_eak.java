package leetcode;

public class _1765_Map_of_Highest_eak {
    public int[][] highestPeak(int[][] isWater) {
        int[][] result = new int[isWater.length][isWater.length];
        for(int i = 0; i < isWater.length; i++) {
            for(int j = 0; j < isWater[0].length; j++) {
                if(isWater[i][j] == 1) {
                    if(j - 1 >= 0 && isWater[i][j - 1] != 1)
                        result[i][j - 1] = 1;
                    if(j + 1 < isWater[0].length && isWater[i][j + 1] != 1)
                        result[i][j + 1] = 1;
                    if(i - 1 >= 0 && isWater[i - 1][j] != 1)
                        result[i - 1][j] = 1;
                    if(i + 1 < isWater.length  && isWater[i + 1][j] != 1)
                        result[i + 1][j] = 1;
                    result[i][j] = 0;
                } else {
                    result[i][j] = -1;
                }
            }
        }
        for(int i = 0; i < isWater.length; i++) {
            for(int j = 0; j < isWater[0].length; j++) {
                if(result[i][j] < 0) {
                    int min = Integer.MAX_VALUE;
                    if(j - 1 >= 0 && result[i][j - 1] != -1)
                        min = Math.min(min, result[i][j - 1]);
                    if(j + 1 < isWater[0].length && result[i][j + 1] != -1)
                        min = Math.min(min, result[i][j +1]);
                    if(i - 1 >= 0 && result[i - 1][j] != -1)
                        min = Math.min(min, result[i - 1][j]);
                    if(i + 1 < isWater.length && result[i + 1][j] != -1)
                        min = Math.min(min, result[i + 1][j]);
                    result[i][j] = min + 1;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        new _1765_Map_of_Highest_eak().highestPeak(new int[][]{
                {0, 0, 0, 0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0, 0, 0, 0}
        });
    }
}
