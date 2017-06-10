package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
  
 You need to find the largest value in each row of a binary tree.

Example:
Input: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

Output: [1, 3, 9] 
  
 * 
 * @author mengchaowang
 *
 */
public class Q515 {
	public int[] findValueMostElement(TreeNode root) {
		if (root == null) {
			return new int[0];
		}
		Queue<TreeNode> q = new LinkedList<>();
		Queue<TreeNode> tmp = new LinkedList<>();
		q.offer(root);
		List<Integer> rel = new ArrayList<Integer>();
		int max = Integer.MIN_VALUE;
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			max = node.val > max ? node.val : max;
			if (node.left != null) {
				tmp.offer(node.left);
			}
			if (node.right != null) {
				tmp.offer(node.right);
			}

			if (q.isEmpty()) {
				rel.add(max);
				max = Integer.MIN_VALUE;
				while (!tmp.isEmpty()) {
					q.offer(tmp.poll());
				}
			}
		}
		int[] re = new int[rel.size()];
		for (int i = 0; i < rel.size(); i++) {
			re[i] = rel.get(i);
		}
		return re;
	}
}
