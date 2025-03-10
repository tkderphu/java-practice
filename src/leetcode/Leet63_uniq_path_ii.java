package leetcode;

import java.util.Arrays;

public class Leet63_uniq_path_ii {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, 0, obstacleGrid, n, m, dp);
    }

    private int solve(int i, int j, int[][] obstacleGrid, int n, int m, int[][] dp) {
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        if(obstacleGrid[i][j] == 1) {
            return dp[i][j] = 0;
        }
        if(i == n - 1 && j == m - 1) {
            return 1;
        }
        int count = 0;
        if(i + 1 < n) {
            count += solve(i + 1, j, obstacleGrid, n, m, dp);
        }
        if(j + 1 < m) {
            count += solve(i, j + 1, obstacleGrid, n, m, dp);
        }

        return dp[i][j] = count;
    }
}
