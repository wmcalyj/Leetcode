package com.leetcode.java;

/**
 * Created by mengchaowang on 6/17/17.
 *

 Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the given depth d. The root node is at depth 1.

 The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1, create two tree nodes with value v as N's left subtree root and right subtree root. And N's original left subtree should be the left subtree of the new left subtree root, its original right subtree should be the right subtree of the new right subtree root. If depth d is 1 that means there is no depth d-1 at all, then create a tree node with value v as the new root of the whole original tree, and the original tree is the new root's left subtree.

 Example 1:
 Input:
 A binary tree as following:
 4
 /   \
 2     6
 / \   /
 3   1 5

 v = 1

 d = 2

 Output:
 4
 / \
 1   1
 /     \
 2       6
 / \     /
 3   1   5

 Example 2:
 Input:
 A binary tree as following:
 4
 /
 2
 / \
 3   1

 v = 1

 d = 3

 Output:
 4
 /
 2
 / \
 1   1
 /     \
 3       1
 Note:
 The given d is in range [1, maximum depth of the given tree + 1].
 The given binary tree has at least one tree node.

 *
 */
public class Q623 {

  public TreeNode addOneRow(TreeNode root, int v, int d) {
    if (d == 1) {
      TreeNode newRoot = new TreeNode(v);
      newRoot.left = root;
      return newRoot;
    } else {
      insertNodeRow(root, v, d - 1);
      return root;
    }
  }

  private void insertNodeRow(TreeNode parent, int v, int depth) {
    if (depth == 1) {
      TreeNode newNode1 = new TreeNode(v);
      newNode1.left = parent.left;
      parent.left = newNode1;
      TreeNode newNode2 = new TreeNode(v);
      newNode2.right = parent.right;
      parent.right = newNode2;
    } else {
      if (parent.left != null) {
        insertNodeRow(parent.left, v, depth - 1);

      }
      if (parent.right != null) {
        insertNodeRow(parent.right, v, depth - 1);
      }
    }
  }
}
