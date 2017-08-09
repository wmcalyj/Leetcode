package com.leetcode.java;

/**
 *


 Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.


 * @author mengchaowang
 *
 */

public class Q104 {

  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = maxDepth(root.left) + 1;
    int right = maxDepth(root.right) + 1;
    return Math.max(left, right);
  }
}
