package com.leetcode.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *

 Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

 Example:

 Input:

 1
 \
 3
 /
 2

 Output:
 1

 Explanation:
 The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 Note: There are at least two nodes in this BST.


 *
 * @author mengchaowang
 *
 */
public class Q530 {

  public int getMinimumDifference(TreeNode root) {
    List<Integer> numbers = new ArrayList<Integer>();
    loopThrough(numbers, root);
    Collections.sort(numbers);
    int min = Integer.MAX_VALUE;
    for (int i = 1; i < numbers.size(); i++) {
      min = Math.min(min, numbers.get(i) - numbers.get(i - 1));
    }
    return min;
  }

  private void loopThrough(List<Integer> numbers, TreeNode root) {
    if (root == null) {
      return;
    }
    numbers.add(root.val);
    if (root.left != null) {
      loopThrough(numbers, root.left);
    }
    if (root.right != null) {
      loopThrough(numbers, root.right);
    }
  }
}
