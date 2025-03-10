package leetcode;

import java.util.*;

public class Leet78_subset {
    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        set.add(new ArrayList<>());
        solve(set, nums, 0, new ArrayList<>());
        return new ArrayList<>(set);
    }

    private void solve(Set<List<Integer>> set, int[] nums, int index, List<Integer> res) {
        for(int i = index; i < nums.length; i++) {
            res.add(nums[i]);
            set.add(new ArrayList<>(res));
            solve(set, nums, i + 1, res);
            res.remove((Integer) nums[i]);
        }
    }

    public static void main(String[] args) {
        new Leet78_subset().subsets(new int[]{1, 2, 3});
    }
}
