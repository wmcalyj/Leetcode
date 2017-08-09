package com.leetcode.java;
// @formatter:off

/**
 * Created by mengchaowang on 7/4/17.

Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Note: Time complexity should be O(height of tree).

Example:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

    5
   / \
  4   6
 /     \
2       7

Another valid answer is [5,2,6,null,4,null,7].

    5
   / \
  2   6
   \   \
    4   7

 */

// @formatter:on
public class Q450 {

  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
      return null;
    }
    if (root.val == key) {
      if (root.right == null) {
        return root.left;
      } else {
        TreeNode newRoot = root.right;
        findSmallest(newRoot).left = root.left;
        return newRoot;
      }
    }
    if (key > root.val) {
      deleteRightNode(root, root.right, key);
    } else {
      deleteLeftNode(root, root.left, key);
    }
    return root;
  }

  private void deleteRightNode(TreeNode parent, TreeNode node, int key) {
    if (node == null) {
      return;
    } else {
      if (key == node.val) {
        if (node.right == null) {
          parent.right = node.left;
        } else {
          TreeNode newChildNode = node.right;
          findSmallest(newChildNode).left = node.left;
          parent.right = newChildNode;
        }
      } else if (key > node.val) {
        deleteRightNode(node, node.right, key);
      } else {
        deleteLeftNode(node, node.left, key);

      }
    }
  }

  private void deleteLeftNode(TreeNode parent, TreeNode node, int key) {
    if (node == null) {
      return;
    } else {
      if (key == node.val) {
        if (node.right == null) {
          parent.left = node.left;
        } else {
          TreeNode newChildNode = node.right;
          findSmallest(newChildNode).left = node.left;
          parent.left = newChildNode;
        }
      } else if (key > node.val) {
        deleteRightNode(node, node.right, key);
      } else {
        deleteLeftNode(node, node.left, key);

      }
    }
  }

  public TreeNode findSmallest(TreeNode node) {
    if (node.left == null && node.right == null) {
      return node;
    }
    if (node == null) {
      return node;
    }
    if (node.left != null) {
      return findSmallest(node.left);
    } else {
      return node;
    }
  }
}
