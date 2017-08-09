package com.leetcode.java;

import java.util.ArrayList;
import java.util.List;

/**
 *

 Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

 Example 1:
 Given tree s:

 3
 / \
 4   5
 / \
 1   2
 Given tree t:
 4
 / \
 1   2
 Return true, because t has the same structure and node values with a subtree of s.
 Example 2:
 Given tree s:

 3
 / \
 4   5
 / \
 1   2
 /
 0
 Given tree t:
 4
 / \
 1   2
 Return false.

 *
 * @author mengchaowang
 *
 */
public class Q572 {

  public boolean isSubtree(TreeNode s, TreeNode t) {
    List<Integer> tList = new ArrayList<>();
    convertToList(t, tList);
    List<Integer> sList = new ArrayList<>();
    convertToList(s, sList);
    String sStr = toString(sList);
    String tStr = toString(tList);
    int idx = sStr.indexOf(tStr);
    return (idx == 0 || (idx > 0 && sStr.charAt(idx - 2) == ','));
  }

  private String toString(List<Integer> list) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < list.size(); i++) {
      sb.append(list.get(i)).append(", ");
    }
    return sb.toString();
  }

  private void convertToList(TreeNode node, List<Integer> list) {
    if (node == null) {
      list.add(null);
      return;
    } else {
      list.add(node.val);
      convertToList(node.left, list);
      convertToList(node.right, list);
    }

  }

}
