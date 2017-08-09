package com.leetcode.java;
// @formatter:off

import java.util.HashMap;
import java.util.Map; /**
 * Created by mengchaowang on 8/5/17.

Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:
Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
Example 2:
Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False

 */

// @formatter:on
public class Q653 {

  public boolean findTarget(TreeNode root, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    traverse(map, root);
    for (Integer key : map.keySet()) {
      int remain = k - key;
      if (remain != key && map.containsKey(remain)) {
        return true;
      }
      if (remain == key && map.get(key) >= 2) {
        return true;
      }
    }
    return false;
  }

  public void traverse(Map<Integer, Integer> map, TreeNode node) {
    if (node == null) {
      return;
    }
    int nodeVal = node.val;
    int count = map.containsKey(nodeVal) ? map.get(nodeVal) + 1 : 1;
    map.put(nodeVal, count);
    traverse(map, node.left);
    traverse(map, node.right);
  }

}
