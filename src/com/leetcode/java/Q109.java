//package com.leetcode;
//
///**
// *
//
// Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
//
// *
// * @author mengchaowang
// *
// */
//public class Q109 {
//	public TreeNode sortedListToBST(ListNode head) {
//		if (head == null) {
//			return null;
//		}
//		return sortedListToBST(head, null);
//
//	}
//
//	public ListNode findMiddle(ListNode head, ListNode tail) {
//		ListNode fast = head;
//		ListNode slow = head;
//		while (fast != tail && fast.next != tail) {
//			fast = fast.next.next;
//			slow = slow.next;
//		}
//		return slow;
//	}
//
//	public TreeNode sortedListToBST(ListNode head, ListNode tail) {
//		if (head == null || head == tail) {
//			return null;
//		}
//		if (head.next == tail) {
//			return new TreeNode(head.val);
//		}
//		ListNode middle = findMiddle(head, tail);
//		TreeNode node = new TreeNode(middle.val);
//		node.left = sortedListToBST(head, middle);
//		node.right = sortedListToBST(middle.next, tail);
//		return node;
//	}
//
//	private ListNode list;
//
//	public TreeNode sortedListToBST2(ListNode head) {
//		int n = 0;
//		ListNode p = head;
//		while (p != null) {
//			p = p.next;
//			n++;
//		}
//		list = head;
//		return sortedListToBST2(0, n - 1);
//
//	}
//
//	private TreeNode sortedListToBST2(int start, int end) {
//		if (start > end)
//			return null;
//		int mid = (start + end) / 2;
//		TreeNode leftChild = sortedListToBST2(start, mid - 1);
//		TreeNode parent = new TreeNode(list.val);
//		parent.left = leftChild;
//		list = list.next;
//		parent.right = sortedListToBST(mid + 1, end);
//		return parent;
//	}
//}
