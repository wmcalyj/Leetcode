package com.leetcode.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *

 Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


 OJ's undirected graph serialization:
 Nodes are labeled uniquely.

 We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 As an example, consider the serialized graph {0,1,2#1,2#2,2}.

 The graph has a total of three nodes, and therefore contains three parts as separated by #.

 First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 Second node is labeled as 1. Connect node 1 to node 2.
 Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 Visually, the graph looks like the following:

 1
 / \
 /   \
 0 --- 2
 / \
 \_/

 *
 * @author mengchaowang
 *
 */
public class Q133 {

  // BSF
  public UndirectedGraphNode cloneGraphBSF(UndirectedGraphNode node) {
    if (node == null) {
      return null;
    }

    Queue<UndirectedGraphNode> original = new LinkedList<UndirectedGraphNode>();
    Queue<UndirectedGraphNode> target = new LinkedList<UndirectedGraphNode>();
    original.add(node);
    UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
    target.add(newHead);
    Set<UndirectedGraphNode> neighbors = new HashSet<UndirectedGraphNode>();
    Map<Integer, UndirectedGraphNode> newNeighborsSet = new HashMap<Integer, UndirectedGraphNode>();

    while (!original.isEmpty()) {
      UndirectedGraphNode oCurr = original.poll();
      UndirectedGraphNode tCurr = target.poll();
      List<UndirectedGraphNode> newNeighbors = tCurr.neighbors;
      for (int i = 0, j = oCurr.neighbors.size(); i < j; i++) {
        UndirectedGraphNode tmp = oCurr.neighbors.get(i);
        if (tmp.label != oCurr.label && !neighbors.contains(tmp)) {
          UndirectedGraphNode newTmp = new UndirectedGraphNode(tmp.label);
          newNeighbors.add(newTmp);
          original.add(tmp);
          target.add(newTmp);
          neighbors.add(tmp);
          newNeighborsSet.put(tmp.label, newTmp);
        } else {
          if (tmp.label == oCurr.label) {
            newNeighbors.add(tCurr);
          } else {
            newNeighbors.add(newNeighborsSet.get(tmp.label));
          }
        }
      }
      tCurr.neighbors = newNeighbors;
    }
    return newHead;
  }

  // DSF
  public UndirectedGraphNode cloneGraphDSF(UndirectedGraphNode node) {
    return null;
  }
}
