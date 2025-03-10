package leetcode;

import java.util.Arrays;

public class Leet53_MaximunArray {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        int n = nums.length;
        int dp[][] = new int[n + 1][n + 1];
        for(int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        dp[1][1] = nums[0];
        for(int i = 2; i <=n; i++) {
            if(nums[i - 1] > dp[i - 1][i - 1]) {
                dp[i][i] = nums[i - 1];
            }
            else {
                dp[i][i] = Math.max(dp[i - 1][i], dp[i - 1][i - 1]);
            }
            dp[i - 1][i] = dp[i - 1][i - 1] + nums[i - 1];
        }
        return dp[n][n];
    }

    public static void main(String[] args) {
        new Leet53_MaximunArray().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
}
