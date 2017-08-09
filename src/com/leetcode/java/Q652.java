package com.leetcode.java;
// @formatter:off

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set; /**
 * Created by mengchaowang on 8/7/17.

Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with same node values.

Example 1:
        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
The following are two duplicate subtrees:
      2
     /
    4
and
    4
Therefore, you need to return above trees' root in the form of a list.


 */

// @formatter:on
public class Q652 {

  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    Map<Integer, List<TreeNode>> valToNodes = new HashMap<>();
    List<TreeNode> re = new ArrayList<>();
    loopWholeTree(root, valToNodes);
    for (Entry<Integer, List<TreeNode>> entry : valToNodes.entrySet()) {
      if (entry.getValue().size() >= 2) {
        List<TreeNode> values = entry.getValue();
        Set<TreeNode> used = new HashSet<>();
        for (int i = 0; i < values.size() - 1; i++) {
          TreeNode nodeI = values.get(i);
          for (int j = i + 1; j < values.size(); j++) {
            TreeNode nodeJ = values.get(j);
            if (isSame(nodeI, nodeJ) &&
                !used.stream().anyMatch(treeNode -> isSame(treeNode, nodeJ))) {
              re.add(values.get(i));
              used.add(nodeI);
            }
          }

        }
      }
    }
    return re;
  }

  private boolean isSame(TreeNode node1, TreeNode node2) {
    if (node1 == null && node2 == null) {
      return true;
    }
    if (node1 == null) {
      return false;
    }
    if (node2 == null) {
      return false;
    }
    if (node1.val != node2.val) {
      return false;
    }
    return isSame(node1.left, node2.left) && isSame(node1.right, node2.right);
  }

  private void loopWholeTree(TreeNode node, Map<Integer, List<TreeNode>> valToNodes) {
    if (node == null) {
      return;
    }
    int val = node.val;
    List<TreeNode> nodes;
    if (valToNodes.containsKey(val)) {
      nodes = valToNodes.get(val);
    } else {
      nodes = new ArrayList<>();
    }
    nodes.add(node);
    valToNodes.put(val, nodes);
    if (node.left != null) {
      loopWholeTree(node.left, valToNodes);
    }
    if (node.right != null) {
      loopWholeTree(node.right, valToNodes);
    }
  }
}
