package com.leetcode.java;

import java.util.LinkedList;
import java.util.Queue;

/**
 *

 Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

 Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.

 The encoded string should be as compact as possible.

 Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.

 *
 * @author mengchaowang
 *
 */
public class Q449 {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null) {
      return null;
    }
    Queue<TreeNode> fifo = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    fifo.offer(root);
    while (!fifo.isEmpty()) {
      TreeNode node = fifo.poll();
      if (node == null) {
        sb.append("N,");
      } else {
        sb.append(node.val).append(",");
        fifo.offer(node.left);
        fifo.offer(node.right);
      }
    }
    System.out.println(sb.toString());
    return sb.substring(0, sb.length() - 1);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data == null || data.length() == 0) {
      return null;
    }
    String[] nodeStrs = data.split(",");
    TreeNode head = new TreeNode(Integer.valueOf(nodeStrs[0]));
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(head);
    int count = 0;
    int left = 2 * count + 1;
    int right = 2 * count + 2;
    while (!queue.isEmpty() && left < nodeStrs.length && right < nodeStrs.length) {
      TreeNode node = queue.poll();
      left = 2 * count + 1;
      right = 2 * count + 2;
      if (node == null) {
        continue;
      }
      node.left = nodeStrs[left].equals("N") ? null : new TreeNode(Integer.valueOf(nodeStrs[left]));
      node.right =
          nodeStrs[right].equals("N") ? null : new TreeNode(Integer.valueOf(nodeStrs[right]));
      queue.offer(node.left);
      queue.offer(node.right);
      count++;
    }
    return head;
  }
}
