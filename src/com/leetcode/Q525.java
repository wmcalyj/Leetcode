package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
  
 Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Note: The length of the given binary array will not exceed 50,000. 
  
 * 
 * @author mengchaowang
 *
 */
public class Q525 {
	public int findMaxLength(int[] nums) {
		Map<Integer, Integer> valToIdx = new HashMap<>();
		valToIdx.put(0, -1);
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				nums[i] = -1;
			}
		}
		int sum = 0;
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (valToIdx.containsKey(sum)) {
				max = Math.max(max, i - valToIdx.get(sum));
			} else {
				valToIdx.put(sum, i);
			}
		}
		return max;
	}

	private int findSubMaxLength(int[] nums, int idx) {
		int ones = 0, zeroes = 0;
		int subMax = 0;
		for (int i = idx; i < nums.length; i++) {
			if (nums[i] == 0) {
				zeroes++;
			} else {
				ones++;
			}
			if (zeroes == ones) {
				subMax = ones + zeroes;
			}
		}
		return subMax;
	}
}
