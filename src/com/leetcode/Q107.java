package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q107 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		if (root == null) {
			return null;
		}
		Stack<List<TreeNode>> result = new Stack<List<TreeNode>>();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<TreeNode> first = new ArrayList<TreeNode>();
		first.add(root);
		result.push(first);
		List<TreeNode> top;
		while (true) {
			top = result.peek();
			List<TreeNode> level = new ArrayList<TreeNode>();
			for (TreeNode n : top) {
				if (n.left != null) {
					level.add(n.left);
				}
				if (n.right != null) {
					level.add(n.right);
				}
			}
			if (level.isEmpty()) {
				break;
			}
			result.push(level);
		}
		while (!result.isEmpty()) {
			List<Integer> level = new ArrayList<Integer>();
			top = result.pop();
			for (TreeNode n : top) {
				level.add(n.val);
			}
			list.add(level);
		}
		return list;

	}
}
