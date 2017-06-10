package com.leetcode;

/**
 * Given a non-empty binary search tree and a target value, find the value in
 * the BST that is closest to the target.
 * 
 * Note: Given target value is a floating point. You are guaranteed to have only
 * one unique value in the BST that is closest to the target.
 * 
 * @author mengchaowang
 *
 */
public class Q270Lock {
	public int closestValue(TreeNode root, double target) {
		int t;
		if (target > root.val) {
			t = search(root.right, target, root);
		} else {
			t = search(root.left, target, root);
		}
		return Math.abs(target - root.val) < Math.abs(t - target) ? root.val : t;
	}

	public int search(TreeNode root, double target, TreeNode parent) {
		if (root == null) {
			return parent.val;
		}
		if (target > root.val) {
			int larger = search(root.right, target, root);
			return Math.abs(target - root.val) < Math.abs(larger - target) ? root.val : larger;
		} else {
			int smaller = search(root.left, target, root);
			return Math.abs(target - root.val) < Math.abs(smaller - target) ? root.val : smaller;
		}
	}
}
