package com.leetcode.java;

/**
 *

 Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

 Follow up:
 What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

 Show Hint


 *
 * @author mengchaowang
 *
 */
public class Q230 {

  int result;
  int count;

  public int kthSmallest(TreeNode root, int k) {
    count = k;
    traverse(root);
    return result;
  }

  public void traverse(TreeNode root) {
    if (root.left != null) {
      traverse(root.left);
    }
    count--;
    if (count == 0) {
      result = root.val;
      return;
    }

    if (root.right != null) {
      traverse(root.right);
    }
  }
}
