package com.leetcode.java;

/**
 * Created by mengchaowang on 7/3/17.

 Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.

 */
public class Q086 {

  // TODO: There might be another inplace solution.
  public ListNode partition(ListNode head, int x) {
    if (head == null) {
      return null;
    }
    ListNode less = null, more = null;
    ListNode current = head;
    ListNode newHead = null;
    ListNode newHalfHead = null;
    while (current != null) {
      if (current.val < x) {
        if (less == null) {
          less = current;
          newHead = less;
        } else {
          less.next = current;
          less = less.next;
        }
      } else {
        if (more == null) {
          more = current;
          newHalfHead = more;
        } else {
          more.next = current;
          more = more.next;
        }
      }
      current = current.next;
    }
    if (less != null) {
      less.next = newHalfHead;
      if (more != null) {
        more.next = null;
      }
      return newHead;
    } else {
      return newHalfHead;
    }
  }
}
