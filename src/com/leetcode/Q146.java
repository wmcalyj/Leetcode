package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 
 * 
 * @author mengchaowang
 *
 */
public class Q146 {
	public class Node {
		int key;
		int value;
		Node prev;
		Node next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
			prev = null;
			next = null;
		}
	}

	Map<Integer, Node> map;
	int cap;
	int currentSize;
	Node head;
	Node tail;

	public Q146(int capacity) {
		map = new HashMap<Integer, Node>();
		cap = capacity;
		currentSize = 0;
		head = null;
		tail = null;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			update(node);
			return node.value;
		} else {
			return -1;
		}

	}

	private void update(Node node) {
		if (node == head) {
			return;
		}
		if (node.prev != null) {
			node.prev.next = node.next;
		}
		if (node.next != null) {
			node.next.prev = node.prev;
		} else {
			// last one
			tail = node.prev;
		}
		// Move to head;
		node.prev = null;
		node.next = head;
		head.prev = node;
		head = node;

	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			update(node);
			node.value = value;
		} else {
			Node n = new Node(key, value);
			currentSize++;

			if (head == null) {
				// First element
				head = n;
				tail = n;
			} else {
				n.next = head;
				head.prev = n;
				head = n;
			}
			map.put(key, n);
		}
		if (currentSize > cap) {
			int keyToRemove = tail.key;
			tail.prev.next = null;
			tail = tail.prev;
			currentSize--;
			map.remove(keyToRemove);
		}
	}

	public static void main(String[] args) {
		Q146 q = new Q146(1);
		q.set(2, 1);
		print(q);
		System.out.println("get 2: " + q.get(2));
		print(q);
		q.set(3, 2);
		print(q);
		System.out.println("get 2: " + q.get(2));
		print(q);
		System.out.println("get 3: " + q.get(3));
		print(q);
	}

	public static void print(Q146 q) {
		Node head = q.head;
		while (head != null) {
			System.out.print("key: " + head.key + ", Value: " + head.value + " -> ");
			head = head.next;
		}
		System.out.println("NULL");
	}
}
