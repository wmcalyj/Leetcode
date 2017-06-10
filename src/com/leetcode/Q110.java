package com.leetcode;

/**
 * 
 * 
  
 Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
  
 * 
 * @author mengchaowang
 *
 */
public class Q110 {
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 && isBalanced(root.left)
				&& isBalanced(root.right);
	}

	private int getHeight(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
	}

	public boolean isBalanced2(TreeNode root) {
		if (getHeight(root) == -1) {
			return false;
		}
		return true;
	}

	public int getHeight2(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = getHeight(node.left);
		int right = getHeight(node.right);
		if (left == -1 || right == -1) {
			return -1;
		}
		if (Math.abs(left - right) > 1) {
			return -1;
		}
		return left > right ? left + 1 : right + 1;
	}
}
