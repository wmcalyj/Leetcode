package com.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
  
 Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

Example 2:
Given the list [1,[4,[6]]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6]. 
  
 * 
 * @author mengchaowang
 *
 */
public class Q341 implements Iterator<Integer> {
	Queue<Integer> q = new LinkedList<>();

	public Q341(List<NestedInteger> nestedList) {
		loopNestedList(nestedList, q);
	}

	private void loopNestedList(List<NestedInteger> nestedList, Queue<Integer> q2) {
		for (int i = 0; i < nestedList.size(); i++) {
			NestedInteger n = nestedList.get(i);
			if (n.isInteger()) {
				q.offer(n.getInteger());
			} else {
				List<NestedInteger> nested = n.getList();
				loopNestedList(nested, q);
			}
		}
	}

	@Override
	public Integer next() {
		return q.poll();

	}

	@Override
	public boolean hasNext() {
		return !q.isEmpty();

	}
}
