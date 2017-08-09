package com.leetcode.java;
// @formatter:off

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue; /**
 * Created by mengchaowang on 7/8/17.

Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].

 */

// @formatter:on
public class Q637 {

  public List<Double> averageOfLevels(TreeNode root) {
    Queue<TreeNode> current = new LinkedList<>();
    Queue<TreeNode> next = new LinkedList<>();
    current.offer(root);
    List<Double> re = new ArrayList<>();
    start(current, next, re);
    return re;
  }

  private void start(Queue<TreeNode> current, Queue<TreeNode> next, List<Double> re) {
    if (current.isEmpty()) {
      return;
    }
    double sum = 0.0;
    double count = 0.0;
    TreeNode tmp;
    while (!current.isEmpty()) {
      tmp = current.poll();
      sum += tmp.val;
      count++;
      if (tmp.left != null) {
        next.offer(tmp.left);
      }
      if (tmp.right != null) {
        next.offer(tmp.right);
      }
    }
    re.add(sum / count);
    start(next, current, re);
  }
}
