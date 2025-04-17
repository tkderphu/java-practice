package leetcode;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {


      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
     
    
    int cnt = 0;

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0l, 1);
        solve(map, root, targetSum, 0);

        return cnt;
    }

    public void solve(Map<Long, Integer> map, TreeNode root,
                      int targetSum, long prefixSum) {
        if (root == null) {

            return;
        }
        prefixSum += root.val;
        if (map.containsKey(prefixSum - targetSum)) {
            cnt += map.get(prefixSum - targetSum);
        }
        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);

        solve(map, root.left, targetSum, prefixSum);
        solve(map, root.right, targetSum, prefixSum);
        map.put(prefixSum, map.get(prefixSum) - 1);

    }
    public static void main(String[] args) {
    new PathSumIII().pathSum(new TreeNode(1000000000, new TreeNode(
            1000000000, new TreeNode(
            294967296, new TreeNode(1000000000,
            new TreeNode(1000000000, new TreeNode(1000000000), null), null), null
    ), null
    ), null), 0);
    }
}
