package com.leetcode.java;

/**
 *

 Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity. 

 * @author mengchaowang
 *
 */
public class Q023 {

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) {
      return null;
    }
    ListNode dummyHead = new ListNode(0);
    ListNode current = dummyHead;
    ListNode[] n = new ListNode[lists.length];
    int minPos = 0;
    int nullNodes = 0;
    int lastPos = 0;
    while (nullNodes < lists.length - 1) {
      nullNodes = 0;
      for (int i = 0; i < lists.length; i++) {
        if (n[i] == null) {
          nullNodes++;
          continue;
        }
        if (n[i].val < n[minPos].val) {
          minPos = i;
        }
        lastPos = i;
      }
      current.next = n[minPos];
      n[minPos] = n[minPos].next;
      current = current.next;
    }
    if (nullNodes == lists.length - 1) {
      current.next = n[lastPos];
    }
    return dummyHead.next;

  }
}
