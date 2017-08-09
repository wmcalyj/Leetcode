package com.leetcode.java;

/*
 * 
 
  You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
  
 * 
 */
public class Q002 {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode current = dummyHead;
    int carry = 0;
    while (l1 != null && l2 != null) {
      int sum = l1.val + l2.val + carry;
      carry = sum / 10;
      ListNode next = new ListNode(sum % 10);
      current.next = next;
      current = current.next;
      l1 = l1.next;
      l2 = l2.next;
    }
    while (l1 != null) {
      int sum = l1.val + carry;
      carry = sum / 10;
      ListNode next = new ListNode(sum % 10);
      current.next = next;
      current = current.next;
      l1 = l1.next;
    }
    while (l2 != null) {
      int sum = l2.val + carry;
      carry = sum / 10;
      ListNode next = new ListNode(sum % 10);
      current.next = next;
      current = current.next;
      l2 = l2.next;
    }
    if (carry != 0) {
      current.next = new ListNode(carry);
    }
    return dummyHead.next;

  }
}
