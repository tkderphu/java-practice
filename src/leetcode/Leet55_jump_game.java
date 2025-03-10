package leetcode;

public class Leet55_jump_game {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) {
            if(nums[0] >= 1) return true;
            return false;
        }
        boolean[] dp = new boolean[nums.length];
        return solve(0, nums, dp);
    }

    public static boolean solve(int startIndex, int[] nums, boolean dp[]) {
        if(dp[startIndex]) return true;

        if(startIndex >= nums.length) return false;
        if(nums[startIndex] == 0 && startIndex != nums.length - 1) return  false;

        if(startIndex == nums.length - 1 || nums[startIndex] >= nums.length - 1) {
            return dp[startIndex] = true;
        }


        boolean res = false;
        for(int i = startIndex + 1; i <= startIndex  + nums[startIndex]; i++) {
            if(res) break;
            res = res || solve(i, nums, dp);
        }

        return dp[startIndex] = res;
    }

    public static void main(String[] args) {
        new Leet55_jump_game().canJump(new int[]{1,1,1,0});
    }
}
