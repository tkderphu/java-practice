package leetcode;

public class Leet62_unique_path {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        return solve(0, 0, m, n, dp);
    }

    private int solve(int i, int j, int m, int n, int[][] dp) {
        if(dp[i][j] != 0) {
            return dp[i][j];
        }
        if(i == m - 1 && j == n - 1) {
            return 1;
        }
        int count = 0;

        if(i + 1 < m) {
            count += solve(i + 1, j, m, n, dp);
        }

        if(j + 1 < n) {
            count += solve(i, j + 1, m, n, dp);
        }

        return dp[i][j] = count;
    }
}
