package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * 
  
 Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1
Example 2: 
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
Note: You may assume the tree (i.e., the given root node) is not NULL. 
  
 * 
 * @author mengchaowang
 *
 */
public class Q513 {
	public int findLeftMostNode(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		Queue<TreeNode> tmp = new LinkedList<>();
		q.offer(root);
		int re = root.val;
		boolean record = true;
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if (node.left != null) {
				tmp.offer(node.left);
			}
			if (node.right != null) {
				tmp.offer(node.right);
			}
			if (record) {
				re = node.val;
			}
			if (q.isEmpty()) {
				record = true;
				while (!tmp.isEmpty()) {
					q.offer(tmp.poll());
				}
			} else {
				record = false;
			}
		}
		return re;
	}
}
