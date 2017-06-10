package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.leetcode.Q107.TreeNode;

public class Q173 {

	private PriorityQueue<TreeNode> iterator;

	public Q173(TreeNode root) {
		iterator = new PriorityQueue<TreeNode>(new Comparator<TreeNode>() {
			@Override
			public int compare(TreeNode o1, TreeNode o2) {
				return o1.val - o2.val;
			}
		});
		traversal(root, iterator);
	}

	private void traversal(TreeNode root, PriorityQueue<TreeNode> iterator) {
		if (root == null) {
			return;
		}
		iterator.add(root);
		traversal(root.left, iterator);
		traversal(root.right, iterator);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return iterator.size() > 0;
	}

	/** @return the next smallest number */
	public int next() {
		return iterator.poll().val;
	}
}
