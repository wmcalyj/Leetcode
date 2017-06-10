package com.leetcode;

/**
 * 
 
 Sort a linked list in O(n log n) time using constant space complexity.

  
 * @author mengchaowang
 *
 */
public class Q148 {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode newHead = slow.next;
		slow.next = null;
		ListNode left = sortList(head);
		ListNode right = sortList(newHead);
		return mergeList(left, right);
	}

	public ListNode mergeList(ListNode n1, ListNode n2) {
		ListNode dummyHead = new ListNode(0);
		ListNode current = dummyHead;
		ListNode t1 = n1, t2 = n2;
		while (t1 != null && t2 != null) {
			if (t1.val <= t2.val) {
				current.next = t1;
				t1 = t1.next;
			} else {
				current.next = t2;
				t2 = t2.next;
			}
			current = current.next;
		}
		if (t1 != null) {
			current.next = t1;
		}
		if (t2 != null) {
			current.next = t2;
		}
		return dummyHead.next;
	}

}
