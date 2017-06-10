package com.leetcode;

public class Q198 {
	/*
	 * f(k) = max(f(k – 2) + Ak, f(k – 1))
	 */
	public int rob(int[] nums) {
		int prevMax = 0;
		int currMax = 0;
		for (int x : nums) {
			int temp = currMax;
			currMax = Math.max(prevMax + x, currMax);
			prevMax = temp;
		}
		return currMax;
	}
}
