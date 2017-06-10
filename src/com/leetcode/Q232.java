package com.leetcode;

import java.util.Stack;

/**
 * 
 
 Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Notes:
You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 
 * @author mengchaowang
 *
 */
public class Q232 {
	Stack<Integer> stack = new Stack<Integer>();

	// Push element x to the back of queue.
	public void push(int x) {
		if (stack.isEmpty()) {
			stack.push(x);
		} else {
			Stack<Integer> tmp = new Stack<Integer>();
			while (!stack.isEmpty()) {
				tmp.push(stack.pop());
			}
			stack.push(x);
			while (!tmp.isEmpty()) {
				stack.push(tmp.pop());
			}
		}
	}

	// Removes the element from in front of queue.
	public void pop() {
		stack.pop();
	}

	// Get the front element.
	public int peek() {
		return stack.peek();
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		Q232 q = new Q232();
		q.push(7);
		q.push(6);
		q.push(5);
		q.push(4);
		q.push(3);
		q.push(2);
		q.push(1);

		while (!q.empty()) {
			System.out.println(q.peek());
			q.pop();
		}

	}
}
