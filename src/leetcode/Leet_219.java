package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leet_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        if(nums.length == 1) return false;
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) return true;
            }
             map.put(nums[i], i);
        }
        return false;
    }
}
