package leetcode;

public class flattern_binary_tree {
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
    public void flatten(TreeNode root) {
        if (root != null) {
            solve(root, root.left, root.right);
        }
    }

    void solve(TreeNode parent, TreeNode left, TreeNode right) {
        if (right == null && left == null)
            return;
        if (left != null) {

            solve(left, left.left, left.right);
        }
        if (right != null) {

            solve(right, right.left, right.right);
        }
        if(left != null) {
            parent.right = left;
            attach(left, right);
            parent.left = null;
        }
    }

    void attach(TreeNode left, TreeNode right) {
        if (left != null && left.left == null && left.right == null) {
            left.right = right;
            return;
        }
        if (left != null) {
            attach(left.right, right);
        }
    }
    public static void main(String[] args) {
        new flattern_binary_tree().flatten(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null)));
    }
}
