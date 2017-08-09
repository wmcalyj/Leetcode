package com.leetcode.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 *
 *

 Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 Both the left and right subtrees must also be binary search trees.
 For example:
 Given BST [1,null,2,2],
 1
 \
 2
 /
 2
 return [2].

 Note: If a tree has more than one mode, you can return them in any order.

 Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).


 *
 * @author mengchaowang
 *
 */
public class Q501 {

  /**
   * Definition for a binary tree node.
   * public class TreeNode {
   *     int val;
   *     TreeNode left;
   *     TreeNode right;
   *     TreeNode(int x) { val = x; }
   * }
   */

  Map<Integer, Integer> result = new HashMap<Integer, Integer>();

  public int[] findMode(TreeNode root) {
    traverse(root);
    if (result == null || result.size() == 0) {
      return new int[0];
    }
    return findResult();

  }

  private int[] findResult() {
    List<Integer[]> re = new ArrayList<Integer[]>();

    PriorityQueue<Integer[]> pq = new PriorityQueue<>(result.size(), new Comparator<Integer[]>() {
      @Override
      public int compare(Integer[] o1, Integer[] o2) {
        return o2[1] - o1[1];
      }
    });
    for (Entry<Integer, Integer> entry : result.entrySet()) {
      pq.offer(new Integer[]{entry.getKey(), entry.getValue()});
    }
    if (pq == null || pq.isEmpty()) {
      return new int[0];
    }
    re.add(pq.poll());
    while (pq != null && !pq.isEmpty() && pq.peek()[1] >= re.get(re.size() - 1)[1]) {
      re.add(pq.poll());
    }
    int[] res = new int[re.size()];
    for (int i = 0; i < res.length; i++) {
      res[i] = re.get(i)[0];
    }
    return res;
  }

  private void traverse(TreeNode root) {
    if (root == null) {
      return;
    }
    Integer count = result.containsKey(root.val) ? result.get(root.val) + 1 : 1;
    result.put(root.val, count);
    traverse(root.left);
    traverse(root.right);
  }
}
