package com.leetcode;

/**
 * 
 * 

Given a non-negative number represented as a singly linked list of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

Example:
Input:
1->2->3

Output:
1->2->4

 * @author mengchaowang
 *
 */
public class Q369Lock {
	public ListNode plusOne(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode fast, slow, last;
		slow = head;
		if (slow.val >= 10) {
			return new ListNode(0);
		}
		fast = slow.next;
		last = head;

		while (fast != null) {
			if (slow.val >= 10) {
				return new ListNode(0);
			}
			if (slow.val != 9) {
				last = slow;
			}
			fast = fast.next;
			slow = slow.next;
		}
		if (slow.val == 9) {
			if (last == head && last.val == 9) {
				ListNode newHead = new ListNode(1);
				newHead.next = head;
				ListNode tmp = head;
				while (tmp != null) {
					tmp.val = 0;
					tmp = tmp.next;
				}
				return newHead;
			} else {
				ListNode tmp = last.next;
				while (tmp != null) {
					tmp.val = 0;
					tmp = tmp.next;
				}
				last.val += 1;
			}
		} else {
			slow.val += 1;
		}
		return head;
	}
}
