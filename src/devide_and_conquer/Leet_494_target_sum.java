package devide_and_conquer;


public class Leet_494_target_sum {
    public int findTargetSumWays(int[] nums, int target) {
        int[] binary = new int[nums.length];
        return solve(binary, 0, target, nums);
    }

    private int solve(int[] binary, int index, int target, int[] nums) {
        if(index == binary.length) {
            int sum = 0;
            for(int i = 0; i < binary.length; i++) {
                if(binary[i] == 0) {
                    sum -= nums[i];
                } else {
                    sum += nums[i];
                }
            }
            if(sum == target) {
                return 1;
            }
            return 0;
        }
        int res = 0;
        for(int i = 0; i <= 1; i++) {
            binary[index] = i;
            res += solve(binary, index + 1, target, nums);
        }
        return res;
    }

    public static void main(String[] args) {
        new Leet_494_target_sum().findTargetSumWays(new int[]{1}, 1);
    }
}
