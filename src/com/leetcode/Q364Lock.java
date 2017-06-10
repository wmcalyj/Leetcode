package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.leetcode.Q339Lock.NestedInteger;

/**
 * 
 
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.

Example 1:
Given the list [[1,1],2,[1,1]], return 8. (four 1's at depth 1, one 2 at depth 2)

Example 2:
Given the list [1,[4,[6]]], return 17. (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17) 

 * 
 * @author mengchaowang
 *
 */
public class Q364Lock {

	/**
	 * // This is the interface that allows for creating nested lists.
	 * // You should not implement it, or speculate about its implementation
	 * public interface NestedInteger {
	 *     // Constructor initializes an empty nested list.
	 *     public NestedInteger();
	 *
	 *     // Constructor initializes a single integer.
	 *     public NestedInteger(int value);
	 *
	 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
	 *     public boolean isInteger();
	 *
	 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
	 *     // Return null if this NestedInteger holds a nested list
	 *     public Integer getInteger();
	 *
	 *     // Set this NestedInteger to hold a single integer.
	 *     public void setInteger(int value);
	 *
	 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
	 *     public void add(NestedInteger ni);
	 *
	 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
	 *     // Return null if this NestedInteger holds a single integer
	 *     public List<NestedInteger> getList();
	 * }
	 */

	public int depthSumInverse(List<NestedInteger> nestedList) {
		Stack<List<Integer>> stack = new Stack<List<Integer>>();
		for (NestedInteger i : nestedList) {
			processLevel(i, 1, stack);
		}
		int count = stack.size();
		int sum = 0;
		while (!stack.isEmpty()) {
			for (Integer i : stack.pop()) {
				sum += count * i;
			}
			count--;
		}
		return sum;
	}

	public void processLevel(NestedInteger nestedList, int level, Stack<List<Integer>> stack) {
		int tmp = 1;
		if (nestedList.isInteger()) {
			Stack<List<Integer>> cache = new Stack<List<Integer>>();
			while (tmp < level) {
				if (stack.isEmpty()) {
					cache.push(new ArrayList<Integer>());
				} else {
					cache.push(stack.pop());
				}
				tmp++;
			}
			List<Integer> rightLevel = stack.isEmpty() ? new ArrayList<Integer>() : stack.pop();
			rightLevel.add(nestedList.getInteger());
			stack.push(rightLevel);
			while (!cache.isEmpty()) {
				stack.push(cache.pop());
			}
		} else {
			List<NestedInteger> list = nestedList.getList();
			for (NestedInteger i : list) {
				processLevel(i, level + 1, stack);
			}
		}
	}

	public static void print(Stack<List<Integer>> stack) {
		int level = 1;
		while (!stack.isEmpty()) {
			System.out.print("Level " + level++ + "[");
			for (Integer i : stack.pop()) {
				System.out.print(i + ", ");
			}
			System.out.println("]");
		}
	}

}
