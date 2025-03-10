package leetcode;

import java.util.Arrays;

public class Leet_64_minimun_path {
    public static int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int dp[][] = new int[row + 1][col + 1];
        for(int i = 0; i < row; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(row - 1, col - 1, grid, 0, 0,0, dp);
    }

    private static int solve(int n, int m, int[][] grid, int row, int col, int sum, int dp[][]) {
        if(dp[row][col] != -1) {
            return dp[row][col];
        }
        if(row > n || col > m) return Integer.MAX_VALUE;

        sum += grid[row][col];
        if(row == n && col == m) {
            dp[row][col] = grid[row][col];
            return dp[row][col];
        }

        int right = solve(n, m, grid, row,col + 1, sum, dp);
        int bottom = solve(n, m, grid, row + 1, col, sum, dp);

        dp[row][col] = Math.min(right, bottom);
        return dp[row][col];

    }


    public static void main(String[] args) {
        minPathSum(new int[][]{{1, 2}, {1,1}});
    }
}
