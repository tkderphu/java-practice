package leetcode;

import java.util.*;

public class TreeNode {
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
        if(root != null) {
            TreeNode dummy = new TreeNode(0);
            flatten(root.left, dummy);
            flatten(root.right, null);
            dummy.right = (dummy.right == null) ? root.left : dummy.right;

            TreeNode temp = root.right;
            if(root.left != null) {
                root.right = root.left;

                root.left = null;
            }
            if(dummy.right != null) {
                dummy.right.right = temp;
            }
        }
    }
    void flatten(TreeNode node, TreeNode dummy) {
        if(node != null) {
            flatten(node.left, dummy);
            flatten(node.right, dummy);

            TreeNode left = node.left;
            TreeNode right = node.right;

            if(left != null) {
                node.right = left;
                left.right = right;

                if(dummy != null && dummy.right == null) {
                    dummy.right = (right != null) ? right : left;
                }
                node.left = null;
            }

            if(right != null) {
                if(dummy != null && dummy.right == null) {
                    dummy.right = right;
                }
            }

        }
    }

    public static void main(String[] args) {
        new TreeNode().flatten(new TreeNode(
                1,
                new TreeNode(2, null, new TreeNode(3)),
                null
        ));
    }
  }
