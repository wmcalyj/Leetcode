package com.leetcode;

/**
 * 
  
 Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

Example:

Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13 
  
 * 
 * @author mengchaowang
 *
 */
public class Q538 {
	int sum = 0;

	public TreeNode convertBST(TreeNode root) {
		traverseTree(root);
		setVals(root);
		return root;
	}

	private void setVals(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			setVals(root.left);
		}
		int tmp = root.val;
		root.val = sum;
		sum -= tmp;
		if (root.right != null) {
			setVals(root.right);
		}
	}

	private void traverseTree(TreeNode root) {
		if (root == null) {
			return;
		}
		sum += root.val;
		if (root.left != null) {
			traverseTree(root.left);
		}
		if (root.right != null) {
			traverseTree(root.right);
		}
	}
}
