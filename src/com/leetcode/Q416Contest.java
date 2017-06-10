package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
  
 Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:
Both the array size and each of the array element will not exceed 100.

Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.
 
 
 * @author mengchaowang
 *
 */
public class Q416Contest {
	public boolean canPartition(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		Arrays.sort(nums);
		Map<Integer, Integer> numbers = new HashMap<Integer, Integer>();

		int left = 0;
		int i = 0;
		for (i = 0; i < nums.length - 1; i++) {
			left += nums[i];
			int count = numbers.containsKey(nums[i]) ? numbers.get(nums[i]) : 0;
			count++;
			numbers.put(nums[i], count);
		}
		int difference = left - nums[i];
		if (difference % 2 != 0) {
			return false;
		} else {
			int target = difference / 2;
			return findTarget(target, numbers, nums);
		}
	}

	private boolean findTarget(int target, Map<Integer, Integer> numbers, int[] nums) {
		if (numbers.containsKey(target) || target == 0) {
			return true;
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] > target) {
					return false;
				} else {
					if (findTarget(target - nums[i], numbers, nums)) {
						return true;
					}
				}
			}
			return false;
		}
	}

	public static void main(String[] args) {
		Q416Contest q = new Q416Contest();
		int[][] nums = { { 1, 5, 11, 5 }, { 1, 2, 3, 5 } };
		for (int i = 0; i < nums.length; i++) {
			System.out.println(q.canPartition(nums[i]));
		}
	}

}
