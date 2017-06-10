package com.leetcode;

import java.util.Stack;

/**
 * 
 * 
  
 One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #
For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.

Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".

Example 1:
"9,3,4,#,#,1,#,#,2,#,6,#,#"
Return true

Example 2:
"1,#"
Return false

Example 3:
"9,#,#,1"
Return false 
  
 * 
 * 
 * @author mengchaowang
 *
 */
public class Q331 {
	public boolean isValidSerialization(String preorder) {
		String[] nodes = preorder.split(",");
		if (nodes.length < 3) {
			return false;
		}
		if (nodes[0].equals("#")) {
			return false;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
		stack.push(root);
		for (int i = 1; i < nodes.length; i++) {
			print(root);
			if (stack.isEmpty()) {
				return false;
			}
			TreeNode prev = stack.pop();
			TreeNode cur;
			if (nodes[i].equals("#")) {
				cur = null;
			} else {
				cur = new TreeNode(Integer.valueOf(nodes[i]));
			}
			if (prev.left == null) {
				prev.left = cur;
				stack.push(prev);
			} else {
				prev.right = cur;
			}
			if (cur != null) {
				stack.push(cur);
			}
		}
		if (!stack.isEmpty()) {
			while (!stack.isEmpty()) {
				System.out.println(stack.pop().val);
			}
			return false;
		}
		return true;
	}

	private void print(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		loop(sb, root);
		System.out.println(sb.toString());
	}

	private void loop(StringBuilder sb, TreeNode root) {
		if (root == null) {
			sb.append("#,");
		} else {
			sb.append(root.val).append(",");
			loop(sb, root.left);
			loop(sb, root.right);
		}
	}
}
