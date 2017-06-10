package com.leetcode;

/**
 * 
 * 
  
 Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

Example:

Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 
  
 * 
 * @author mengchaowang
 *
 */
public class Q453 {
	public int minMoves(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int re = 0;
		int min = nums[0], minIdx = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < min) {
				min = nums[i];
				minIdx = i;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (i == minIdx) {
				continue;
			} else {
				re += nums[i] - min;
			}
		}
		return re;
	}
}
