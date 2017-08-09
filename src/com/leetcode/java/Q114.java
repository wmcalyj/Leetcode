package com.leetcode.java;

/**
 *

 Given a binary tree, flatten it to a linked list in-place.

 For example,
 Given

 1
 / \
 2   5
 / \   \
 3   4   6
 The flattened tree should look like:
 1
 \
 2
 \
 3
 \
 4
 \
 5
 \
 6

 Hints:
 If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.

 *
 * @author mengchaowang
 *
 */
public class Q114 {

  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      return;
    }
    if (root.left != null) {
      flatten(root.left);
      flatten(root.right);
      root.right = concat(root.left, root.right);
      root.left = null;
    } else {
      flatten(root.right);
    }
  }

  private TreeNode concat(TreeNode flattenedLeft, TreeNode flattenedRight) {
    TreeNode tmp = flattenedLeft;
    while (tmp.right != null) {
      tmp = tmp.right;
    }
    tmp.right = flattenedRight;
    return flattenedLeft;
  }
}
