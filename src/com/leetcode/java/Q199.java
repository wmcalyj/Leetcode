package com.leetcode.java;

import com.leetcode.java.Q107.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q199 {

  public List<Integer> rightSideView(TreeNode root) {
    if (root == null) {
      return new ArrayList<Integer>();
    }
    Stack<List<TreeNode>> stack = new Stack<List<TreeNode>>();
    List<TreeNode> level = new ArrayList<TreeNode>();
    level.add(root);
    while (!level.isEmpty()) {
      stack.push(level);
      List<TreeNode> top = stack.peek();
      level = new ArrayList<TreeNode>();
      for (TreeNode n : top) {
        if (n.left != null) {
          level.add(n.left);
        }
        if (n.right != null) {
          level.add(n.right);
        }
      }
    }
    Stack<Integer> r = new Stack<Integer>();
    while (!stack.isEmpty()) {
      List<TreeNode> top = stack.pop();
      r.add(top.get(top.size() - 1).val);
    }

    List<Integer> result = new ArrayList<Integer>();
    while (!r.isEmpty()) {
      result.add(r.pop());
    }
    return result;
  }
}
