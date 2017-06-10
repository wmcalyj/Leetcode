package com.leetcode;

import java.util.Arrays;

/**
 * 
  
 Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive 32-bit integer exists, you need to return -1.

Example 1:
Input: 12
Output: 21
Example 2:
Input: 21
Output: -1 
  
 * 
 * @author mengchaowang
 *
 */
public class Q556 {

	public int nextGreaterElement(int n) {
		if (currentIsLargest(n)) {
			return -1;
		}

		char[] nums = String.valueOf(n).toCharArray();
		for (int i = nums.length - 1; i >= 0; i--) {
			char tmp = nums[i];
			int idx = findNextSmaller(nums, i, tmp);
			if (idx != -1) {
				nums[i] = nums[idx];
				nums[idx] = tmp;
				char[] sorted = sortRest(nums, idx + 1);
				for (int j = idx + 1; j < nums.length; j++) {
					nums[j] = sorted[j - idx - 1];
				}
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nums.length; i++) {
			sb.append(nums[i]);
		}
		long re = Long.valueOf(sb.toString());
		if (re > Integer.MAX_VALUE) {
			return -1;
		} else
			return (int) re;

	}

	private int findNextSmaller(char[] nums, int idx, char n) {
		for (int i = idx - 1; i >= 0; i--) {
			if (nums[i] < n) {
				return i;
			}
		}
		return -1;
	}

	char[] sortRest(char[] nums, int idx) {
		char[] newNums = Arrays.copyOfRange(nums, idx, nums.length);
		Arrays.sort(newNums);
		return newNums;
	}

	private int fixCurrentPosition(final char[] original, final int index) {
		char[] newNums = Arrays.copyOfRange(original, 0, index);
		if (newNums.length == 0) {
			return -1;
		}
		int cur = Character.getNumericValue(newNums[0]);
		int next = -1;
		int idx = -1;
		for (int i = 1; i < newNums.length; i++) {
			int digit = Character.getNumericValue(newNums[i]);
			if (next == -1 && digit < cur) {
				next = digit;
				idx = i;
			} else {
				if (next != -1 && digit < next && digit > cur) {
					next = digit;
					idx = i;
				}
			}
		}
		if (next == -1) {
			return -1;
		}
		newNums[idx] = '9';
		newNums[0] = '9';
		Arrays.sort(newNums);
		StringBuilder sb = new StringBuilder();
		sb.append(next).append(cur);
		for (int i = 0; i < newNums.length - 2; i++) {
			sb.append(newNums[i]);
		}
		int re = Integer.valueOf(sb.toString());
		return re;
	}

	private boolean currentIsLargest(int n) {
		char[] nums = String.valueOf(n).toCharArray();
		Arrays.sort(nums);
		StringBuilder sb = new StringBuilder();
		for (int i = nums.length - 1; i >= 0; i--) {
			sb.append(nums[i]);
		}

		return n == Long.valueOf(sb.toString());
	}

	public static void main(String[] args) {
		Q556 q = new Q556();
		// int[] nums = { 21, 12, 1, 0, 123, 132, 312, 321 };
		// for (int num : nums) {
		// System.out.println(q.nextGreaterElement(num));
		// }
		System.out.println(q.nextGreaterElement(1999999999));
		// 13222344
		System.out.println(q.nextGreaterElement(12443322));
	}
}
