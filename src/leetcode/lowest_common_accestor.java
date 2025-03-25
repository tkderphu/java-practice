package leetcode;

import java.util.HashMap;
import java.util.Map;

public class lowest_common_accestor {


    public static class TreeNode {
        int val;
        leetcode.TreeNode left;
        leetcode.TreeNode right;
        TreeNode(int x) { val = x; }
    }



    static class Solution {
        class Pair {
            int parentVal;
            int h;

            public Pair(int parentVal, int h) {
                this.parentVal = parentVal;
                this.h = h;
            }
        }

        public leetcode.TreeNode lowestCommonAncestor(leetcode.TreeNode root, leetcode.TreeNode p, leetcode.TreeNode q) {
            Map<Integer, Pair> map = new HashMap<>();
            solve(root, root, p.val, q.val, map, 1);
            Pair p1 = map.get(p.val);
            Pair p2 = map.get(q.val);

            if (p1.h == p2.h) return new leetcode.TreeNode(p1.parentVal);
            else if (p1.h > p2.h) return new leetcode.TreeNode(p.val);
            else return new leetcode.TreeNode(q.val);

        }

        public void solve(leetcode.TreeNode parent, leetcode.TreeNode root, int p, int q, Map<Integer, Pair> map, int h) {
            if (root != null) {
                if (root.val == p) {
                    map.put(root.val, new Pair(parent.val, h));
                } else if (root.val == q) {
                    map.put(root.val, new Pair(parent.val, h));
                }
                solve(root, root.left, p, q, map, h + 1);
                solve(root, root.right, p, q, map, h + 1);
            }
        }
    }

    public static void main(String[] args) {
        new Solution().lowestCommonAncestor(new leetcode.TreeNode(2, new leetcode.TreeNode(1), null),
                new leetcode.TreeNode(2),
                new leetcode.TreeNode(1));
    }
}