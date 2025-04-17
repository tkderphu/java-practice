package leetcode;

import java.util.HashMap;
import java.util.Map;

public class subarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int prefix = 0;
        int count =0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);

            if(map.containsKey(prefix - k)) {
                count = map.get(k - prefix);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        new subarraySumEqualsK().subarraySum(new int[]{1, -1, 0}, 0);
    }
}
