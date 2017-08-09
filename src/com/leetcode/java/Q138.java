package com.leetcode.java;
// @formatter:off

import java.util.HashMap;
import java.util.Map; /**
 * Created by mengchaowang on 7/12/17.

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

 */

// @formatter:on
public class Q138 {

  public class RandomListNode {

    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
      this.label = x;
    }
  }

  public RandomListNode copyRandomList(RandomListNode head) {
    if (head == null) {
      return null;
    }
    RandomListNode tmp = head.next;
    RandomListNode reHead = new RandomListNode(head.label);
    RandomListNode current = reHead;
    Map<RandomListNode, RandomListNode> nodes = new HashMap<>();
    nodes.put(head, reHead);
    while (tmp != null) {
      RandomListNode reNext = new RandomListNode(tmp.label);
      current.next = reNext;
      nodes.put(tmp, reNext);
      current = current.next;
      tmp = tmp.next;
    }
    tmp = head;
    current = reHead;

    while (tmp != null) {
      RandomListNode reRandom = nodes.get(tmp.random);
      current.random = reRandom;
      current = current.next;
      tmp = tmp.next;
    }
    return reHead;

  }
}
