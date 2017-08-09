package com.leetcode.java;
// @formatter:off

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue; /**
 * Created by mengchaowang on 8/5/17.


Print a binary tree in an m*n 2D string array following these rules:

The row number m should be equal to the height of the given binary tree.
The column number n should always be an odd number.
The root node's value (in string format) should be put in the exactly middle of the first row it can be put. The column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part). You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part. The left-bottom part and the right-bottom part should have the same size. Even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree. However, if two subtrees are none, then you don't need to leave space for both of them.
Each unused space should contain an empty string "".
Print the subtrees following the same rules.
Example 1:
Input:
     1
    /
   2
Output:
[["", "1", ""],
 ["2", "", ""]]
Example 2:
Input:
     1
    / \
   2   3
    \
     4
Output:
[["", "", "", "1", "", "", ""],
 ["", "2", "", "", "", "3", ""],
 ["", "", "4", "", "", "", ""]]
Example 3:
Input:
      1
     / \
    2   5
   /
  3
 /
4
Output:

[["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
Note: The height of binary tree is in the range of [1, 10].

 */

// @formatter:on
public class Q655 {

  public List<List<String>> printTree(TreeNode root) {
    int height = findHeight(root);
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    List<List<String>> result = new ArrayList<>();
    return formResult(queue, result, height - 1);
  }

  private List<List<String>> formResult(Queue<TreeNode> queue,
      List<List<String>> result, int level) {
    if (level < 0) {
      return result;
    }
    List<TreeNode> nodes = new ArrayList<>();
    while (!queue.isEmpty()) {
      nodes.add(queue.poll());
    }
    int spaceCount = (int) (Math.pow(2, level) - 1);
    List<String> tmpResult = new ArrayList<>();
    for (int i = 0; i < nodes.size(); i++) {
      for (int j = 0; j < spaceCount; j++) {
        tmpResult.add("");
      }
      TreeNode node = nodes.get(i);
      if (node == null) {
        tmpResult.add("");
        queue.add(null);
        queue.add(null);
      } else {
        tmpResult.add(node.val + "");
        queue.add(node.left);
        queue.add(node.right);
      }
      for (int j = 0; j < spaceCount; j++) {
        tmpResult.add("");
      }
      if (i < nodes.size() - 1) {
        tmpResult.add("");
      }

    }
    result.add(tmpResult);
    return formResult(queue, result, level - 1);

  }

  public int findHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null) {
      return 1;
    }
    if (root.left != null && root.right != null) {
      return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
    }
    if (root.left == null) {
      return findHeight(root.right) + 1;
    }
    if (root.right == null) {
      return findHeight(root.left) + 1;
    }
    return -1;
  }
}
