package com.leetcode.java;

import java.util.Stack;

/**
 *
 *

 You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Follow up:
 What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

 Example:

 Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 8 -> 0 -> 7

 *
 *
 * @author mengchaowang
 *
 */
public class Q445 {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null || l1.val == 0) {
      return l2;
    }
    if (l2 == null || l2.val == 0) {
      return l1;
    }
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    while (l1 != null) {
      s1.push(l1.val);
      l1 = l1.next;
    }
    while (l2 != null) {
      s2.push(l2.val);
      l2 = l2.next;
    }
    ListNode re = null;
    int carry = 0;
    while (!s1.isEmpty() && !s2.isEmpty()) {
      int sum = s1.pop() + s2.pop() + carry;
      if (sum >= 10) {
        sum = sum % 10;
        carry = 1;
      } else {
        carry = 0;
      }
      ListNode tmp = new ListNode(sum);
      tmp.next = re;
      re = tmp;
    }
    while (!s1.isEmpty()) {
      int sum = s1.pop() + carry;
      if (sum >= 10) {
        sum = sum % 10;
        carry = 1;
      } else {
        carry = 0;
      }
      ListNode tmp = new ListNode(sum);
      tmp.next = re;
      re = tmp;
    }
    while (!s2.isEmpty()) {
      int sum = s2.pop() + carry;
      if (sum >= 10) {
        sum = sum % 10;
        carry = 1;
      } else {
        carry = 0;
      }
      ListNode tmp = new ListNode(sum);
      tmp.next = re;
      re = tmp;
    }
    if (carry == 1) {
      ListNode tmp = new ListNode(1);
      tmp.next = re;
      re = tmp;
    }
    return re;
  }
}
