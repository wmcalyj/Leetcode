package com.leetcode.java;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q173 {

  private PriorityQueue<Q107.TreeNode> iterator;

  public Q173(Q107.TreeNode root) {
    iterator = new PriorityQueue<Q107.TreeNode>(new Comparator<Q107.TreeNode>() {
      @Override
      public int compare(Q107.TreeNode o1, Q107.TreeNode o2) {
        return o1.val - o2.val;
      }
    });
    traversal(root, iterator);
  }

  private void traversal(Q107.TreeNode root, PriorityQueue<Q107.TreeNode> iterator) {
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
