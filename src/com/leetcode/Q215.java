package com.leetcode;

import java.util.PriorityQueue;

/**
 * 
 * 
  
 Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length. 
  
 * @author mengchaowang
 *
 */
public class Q215 {
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> stack = new PriorityQueue<>(k);
		for (int i = 0, j = nums.length; i < j; i++) {
			if (stack.size() < k) {
				stack.offer(nums[i]);
			} else {
				if (nums[i] > stack.peek()) {
					stack.poll();
					stack.offer(nums[i]);
				}
			}
		}
		return stack.poll();
	}
}
