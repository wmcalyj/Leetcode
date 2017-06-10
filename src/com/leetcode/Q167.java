package com.leetcode;

/**
 * 
 * 
  
 Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution and you may not use the same element twice.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2 
  
 * 
 * @author mengchaowang
 *
 */
public class Q167 {
	public int[] twoSum(int[] numbers, int target) {
		int current = -1;
		for (int i = 0; i < numbers.length; i++) {
			int k = -1;
			if (current != -1 && numbers[i] == current) {
				continue;
			} else {
				current = numbers[i];
			}
			if ((k = findMatch(target - current, numbers, i + 1, numbers.length - 1)) != -1) {
				return new int[] { i + 1, k + 1 };
			}
		}
		return new int[2];
	}

	private int findMatch(int num, int[] numbers, int left, int right) {
		if (left > right) {
			return -1;
		}
		int mid = (left + right) / 2;
		if (numbers[mid] == num) {
			return mid;
		} else if (numbers[mid] < num) {
			return findMatch(num, numbers, mid + 1, right);
		} else {
			return findMatch(num, numbers, left, mid - 1);
		}
	}
}
