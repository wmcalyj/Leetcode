package com.leetcode;

/**
 * 
  
 Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].

You need to return the number of important reverse pairs in the given array.

Example1:

Input: [1,3,2,3,1]
Output: 2
Example2:

Input: [2,4,3,5,1]
Output: 3
Note:
The length of the given array will not exceed 50,000.
All the numbers in the input array are in the range of 32-bit integer. 
  
 * 
 * @author mengchaowang
 *
 */
public class Q493 {
	public int reversePairs(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] != 0 && (nums[i] / nums[j] > 2 || (nums[i] / nums[j] == 2 && nums[i] % nums[j] != 0))) {
					count++;
				}
			}
		}
		return count;
	}
}
