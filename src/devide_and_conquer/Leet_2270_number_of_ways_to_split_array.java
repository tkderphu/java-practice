package devide_and_conquer;

public class Leet_2270_number_of_ways_to_split_array {
    public int waysToSplitArray(int[] nums) {
        long sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int count = 0;
        int l = 0;
        long leftSum = 0;
        while (l < nums.length - 1) {
            leftSum += nums[l];
            long rightSum = sum - leftSum;
            if(leftSum >= rightSum) {
                count ++;
            }
            l++;
        }
        return count;
    }
}
