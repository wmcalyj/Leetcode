package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 
 Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
Update (2015-06-11):
The class name of the Java function had been updated to MyStack instead of Stack.
 
 * @author mengchaowang
 *
 */
public class Q225 {
	Queue<Integer> q = new LinkedList<Integer>();

	// Push element x to the back of queue.
	public void push(int x) {
		if (q.isEmpty()) {
			q.offer(x);
		} else {
			Queue<Integer> tmp = new LinkedList<Integer>();
			while (!q.isEmpty()) {
				tmp.offer(q.poll());
			}
			q.offer(x);
			while (!tmp.isEmpty()) {
				q.offer(tmp.poll());
			}
		}
	}

	// Removes the element from in front of queue.
	public void pop() {
		q.remove();
	}

	// Get the top element.
	public int top() {
		return q.peek();
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return q.isEmpty();
	}
}
