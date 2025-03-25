package leetcode;

public class flatten_link_list {
    
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
          public void flatten(TreeNode root) {
              TreeNode dummy = new TreeNode();
              solve(root, null, dummy);
              if(dummy.right == null) {
                  if(root != null && root.left != null) {
                      var tmp = root.right;
                      root.right = root.left;
                      root.right.right = tmp;
                      root.left = null;
                  }
              } else {
                  var tmp = root.right;
                  root.right = root.left;
                  root.left = null;
                  dummy.right.right = tmp;
              }

              System.out.println(root);

          }
          public void solve(TreeNode node, TreeNode parent, TreeNode dummy) {
              if(node != null) {
                  solve(node.left, node, dummy);
                  solve(node.right, node, dummy);

                  if(node.left != null && parent != null) {
                      node.left.right = node.right;
                      node.right = node.left;
                      node.left = null;
                      if(dummy.right == null) {
                          dummy.right = (right == null) ? left : right;
                      }
                  }
              }
          }
      }

    public static void main(String[] args) {
        new TreeNode().flatten(new TreeNode(
                1,  new TreeNode(2,
                new TreeNode(3, new TreeNode(3, new TreeNode(5), new TreeNode(6)), null), new TreeNode(4)), null
        ));
    }
     
}
