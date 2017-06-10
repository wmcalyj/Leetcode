package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 
  
 Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees. 
  
 * 
 * 
 * @author mengchaowang
 *
 */

public class Q098 {
	public boolean isValidBST(TreeNode root) {
		Set<Integer> duplicates = new HashSet<Integer>();
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE, duplicates);
	}

	public boolean isValidBST(TreeNode node, int min, int max, Set<Integer> dup) {
		if (node == null) {
			return true;
		}
		if (!dup.add(node.val)) {
			return false;
		}
		if (node.left == null && node.right == null) {
			return true;
		}
		boolean left = false, right = false;
		if (node.left != null) {
			if (node.left.val >= node.val || (node.left.val <= min && min != Integer.MIN_VALUE)) {
				return false;
			} else {
				int newMax = node.val < max ? node.val : max;
				left = isValidBST(node.left, min, newMax, dup);
			}
		} else {
			left = true;
		}
		if (node.right != null) {
			if (node.right.val <= node.val || (node.right.val >= max && max != Integer.MAX_VALUE)) {
				return false;
			} else {
				int newMin = node.val > min ? node.val : min;
				right = isValidBST(node.right, newMin, max, dup);
			}
		} else {
			right = true;
		}
		return left && right;

	}
}
