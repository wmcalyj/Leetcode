package com.leetcode.java;

/**
 * Created by mengchaowang on 7/1/17.

 Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.

 */
public class Q061 {

  /** Faster / Slower pointer */
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) {
      return null;
    }

    int listLength = getListNodeLength(head);
    k = k >= listLength ? k % listLength : k;
    ListNode nodeK = head;
    for (int i = 0; i < k; i++) {
      nodeK = nodeK.next;
      if (nodeK == null) {
        nodeK = head;
      }
    }
    ListNode slowNode = head;
    if (slowNode == nodeK) {
      return head;
    }
    while (nodeK.next != null) {
      slowNode = slowNode.next;
      nodeK = nodeK.next;
    }
    ListNode newHead = slowNode.next;
    slowNode.next = nodeK.next;
    if (nodeK != head) {
      nodeK.next = head;
    }
    return newHead;
  }

  private int getListNodeLength(ListNode head) {
    ListNode tmp = head;
    int count = 0;
    while (tmp != null) {
      tmp = tmp.next;
      count++;
    }
    return count;
  }
}
