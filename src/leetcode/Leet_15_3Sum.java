package leetcode;

import java.util.*;

public class Leet_15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            int target = 0 - nums[i];
            Map<Integer, Integer> map = new HashMap<>();
            for(int j = i + 1; j < nums.length; j++) {
                if(map.containsKey(nums[j])) {
                    res.add(new ArrayList<>(List.of(nums[i], nums[map.get(nums[j])], nums[j])));
                }
                map.put(target - nums[j], j);
            }
        }
        return new ArrayList<>(res);
    }
}
