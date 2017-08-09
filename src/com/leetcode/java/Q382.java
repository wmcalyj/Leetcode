package com.leetcode.java;

import java.util.Random;

/**
 *

 Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

 Follow up:
 What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?

 Example:

 // Init a singly linked list [1,2,3].
 ListNode head = new ListNode(1);
 head.next = new ListNode(2);
 head.next.next = new ListNode(3);
 Solution solution = new Solution(head);

 // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 solution.getRandom();

 * @author mengchaowang
 *
 */
public class Q382 {

  int totalLength = 0;
  ListNode head;
  Random r;

  /** @param head The linked list's head.
  Note that the head is guaranteed to be not null, so it contains at least one node. */
  public Q382(ListNode head) {
    ListNode tmp = head;
    this.head = head;
    r = new Random();
    while (tmp != null) {
      totalLength++;
      tmp = tmp.next;
    }
  }

  /** Returns a random node's value. */
  public int getRandom() {
    int random = r.nextInt(totalLength);
    ListNode tmp = this.head;
    for (int i = 0; i < random; i++) {
      tmp = tmp.next;
    }
    return tmp.val;
  }
}
