package leetcode;

import java.util.*;

public class Leet_39_combination_sum {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> tmp = new ArrayList<>();
        boolean[] flag = new boolean[1];
        flag[0] = false;
        solve(res, tmp, candidates, target, 0, 0, flag);
        return new ArrayList<>(res);
    }

    private void solve(Set<List<Integer>> res, List<Integer> tmp,
                       int[] candidates, int target,
                       int start, int sum, boolean[] flag) {
        if(sum > target) {
            flag[0] = true;
            return;
        }
        if(sum == target) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = start; i < candidates.length; i++) {
            if(i > start && candidates[i] == candidates[i - 1]) continue;

            tmp.add(candidates[i]);
            solve(res, tmp, candidates, target, i + 1, sum + candidates[i], flag);
            tmp.remove((Integer) candidates[i]);

        }
    }

    public static void main(String[] args) {
        new Leet_39_combination_sum().combinationSum2(new int[]{2,5,2,1,2}, 5);
    }
}
