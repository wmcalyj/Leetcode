package com.leetcode.java;

/**
 *

 Find the sum of all left leaves in a given binary tree.

 Example:

 3
 / \
 9  20
 /  \
 15   7

 There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

 *
 * @author mengchaowang
 *
 */
public class Q404Contest {

  public int sumOfLeftLeaves(TreeNode root) {
    return leftLeave(root);
  }

  public int leftLeave(TreeNode node) {
    int total = 0;
    if (node != null) {
      TreeNode left = node.left;
      if (isLeaf(left)) {
        total += left.val;
      } else {
        total += leftLeave(left);
      }
      if (node.right != null) {
        total += leftLeave(node.right);
      }
    }
    return total;
  }

  private boolean isLeaf(TreeNode node) {
    if (node != null && node.left == null && node.right == null) {
      return true;
    }
    return false;
  }
}
