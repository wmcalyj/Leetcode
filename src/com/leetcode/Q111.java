package com.leetcode;

/**
 * 
  
 Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node. 
  
 * 
 * @author mengchaowang
 *
 */
public class Q111 {
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null) {
			return 1;
		}
		Integer l = null, r = null;
		if (root.left != null) {
			l = minDepth(root.left);
		}
		if (root.right != null) {
			r = minDepth(root.right);
		}
		if (l == null) {
			return r + 1;
		}
		if (r == null) {
			return l + 1;
		}
		return Math.min(l, r) + 1;
	}
}
