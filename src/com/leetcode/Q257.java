package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q257 {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<String>();
		if (root == null) {
			return result;
		}
		binaryTreePaths(root, result, "");
		return result;
	}

	public void binaryTreePaths(TreeNode node, List<String> result, String tmp) {
		if (node.left == null && node.right == null) {
			tmp += node.val;
			result.add(tmp);
			return;
		}
		if (node.left != null) {
			binaryTreePaths(node.left, result, tmp + node.val + "->");
		}
		if (node.right != null) {
			binaryTreePaths(node.right, result, tmp + node.val + "->");
		}
	}

}
