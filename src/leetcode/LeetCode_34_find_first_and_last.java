package leetcode;

import java.util.Arrays;

public class LeetCode_34_find_first_and_last {
    public int[] searchRange(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        int[] res = {-1, -1};
        if(index < 0) return res;

         if(nums[0] == nums[nums.length - 1] && nums[0] == target) {
            res[0] = 0;
            res[1] = nums.length - 1;
        } else {
            int l = index - 1;
            int r = index + 1;

            while(nums[l] == target) {
                res[0] = l;
                l --;
            }
            while(nums[r] == target) {
                res[1] = r;
                r ++;
            }
            if(res[0] == -1) res[0] = index;
            if(res[1] == -1) res[1] = index;
         }
        return res;
    }
}
