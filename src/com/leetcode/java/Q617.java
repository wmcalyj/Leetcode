package com.leetcode.java;

/**
 * Created by mengchaowang on 6/10/17.
 */

/**
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 * <p>
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
 * <p>
 * Example 1:
 * Input:
 * Tree 1                     Tree 2
 * 1                         2
 * / \                       / \
 * 3   2                     1   3
 * /                           \   \
 * 5                             4   7
 * Output:
 * Merged tree:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 */
public class Q617 {

  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) {
      return null;
    }

    TreeNode re = new TreeNode(0);
    TreeNode tmp = re;
    traverse(tmp, t1, t2);
    return re;
  }

  private void traverse(TreeNode re, TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 != null) {
      re.val = t2.val;
    } else if (t1 != null && t2 == null) {
      re.val = t1.val;
    } else if (t1 != null && t2 != null) {
      re.val = t1.val + t2.val;
    } else {
      return;
    }
    if ((t1 != null && t1.left != null) || (t2 != null && t2.left != null)) {
      re.left = new TreeNode(0);
      if (t1 == null) {
        traverse(re.left, null, t2.left);
      }
      if (t2 == null) {
        traverse(re.left, t1.left, null);
      }
      if (t1 != null && t2 != null) {
        traverse(re.left, t1.left, t2.left);
      }
    }
    if ((t1 != null && t1.right != null) || (t2 != null && t2.right != null)) {
      re.right = new TreeNode(0);
      if (t1 == null) {
        traverse(re.right, null, t2.right);
      }
      if (t2 == null) {
        traverse(re.right, t1.right, null);
      }
      if (t1 != null && t2 != null) {
        traverse(re.right, t1.right, t2.right);
      }
    }
  }
}
