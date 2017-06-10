package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.


Example:
Given binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Returns [4, 5, 3], [2], [1].

Explanation:
1. Removing the leaves [4, 5, 3] would result in this tree:

          1
         / 
        2          
2. Now removing the leaf [2] would result in this tree:

          1          
3. Now removing the leaf [1] would result in the empty tree:

          []         
Returns [4, 5, 3], [2], [1].
 
 * @author mengchaowang
 *
 */
public class Q366Lock {

	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}

		while (!isLeaf(root)) {
			List<Integer> tmp = new ArrayList<Integer>();
			findLeaves(root, result, tmp);
			result.add(tmp);
		}
		List<Integer> tmp = new ArrayList<Integer>();
		tmp.add(root.val);
		result.add(tmp);
		return result;
	}

	public boolean findLeaves(TreeNode root, List<List<Integer>> result, List<Integer> tmpResult) {
		if (isLeaf(root)) {
			tmpResult.add(root.val);
			return true;
		} else {
			if (root.left != null) {
				if (findLeaves(root.left, result, tmpResult)) {
					root.left = null;
				}
			}
			if (root.right != null) {
				if (findLeaves(root.right, result, tmpResult)) {
					root.right = null;
				}
			}
		}
		return false;
	}

	public boolean isLeaf(TreeNode node) {
		if (node != null && node.left == null && node.right == null) {
			return true;
		}
		return false;
	}
}
