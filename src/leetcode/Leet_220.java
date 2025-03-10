package leetcode;

import java.util.*;

public class Leet_220 {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> set = new TreeSet<>();
        for(int i =0 ; i < nums.length; i++) {
            Long value = (long)nums[i];
            Long floor = set.floor(value);
            Long ceil = set.ceiling(value);
            if((floor != null && value - floor <= valueDiff) ||
                    (ceil != null && ceil - value <= valueDiff)) {
                return true;
            }
            set.add(value);
            if(set.size() > indexDiff) {
                set.remove(nums[i - indexDiff]);
            }
        }
        return false;
    }
}
