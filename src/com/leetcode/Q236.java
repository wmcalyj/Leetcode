package com.leetcode;

public class Q236 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (!contains(root, p) || !contains(root, q)) {
			return null;
		}
		if ((root == p && contains(root, q)) || (root == q && contains(root, p))) {
			return root;
		}
		if (contains(root.left, p) && contains(root.left, q)) {
			return lowestCommonAncestor(root.left, p, q);
		}
		if (contains(root.right, p) && contains(root.right, q)) {
			return lowestCommonAncestor(root.right, p, q);
		}
		return root;

	}

	public boolean contains(TreeNode node, TreeNode son) {
		if (node == null) {
			return false;
		}
		if (node == son) {
			return true;
		}
		return contains(node.left, son) || contains(node.right, son);

	}
}
