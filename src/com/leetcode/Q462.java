package com.leetcode;

import java.util.Arrays;

/**
 * 
 * 
  
 Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1.

You may assume the array's length is at most 10,000.

Example:

Input:
[1,2,3]

Output:
2

Explanation:
Only two moves are needed (remember each move increments or decrements one element):

[1,2,3]  =>  [2,2,3]  =>  [2,2,2] 
  
 * @author mengchaowang
 *
 */
public class Q462 {
	public int minMoves2(int[] nums) {
		Arrays.sort(nums);
		int re = 0;
		int middle = nums.length / 2;
		int middleV = nums[middle];
		for (int i = 0; i < nums.length; i++) {
			re += Math.abs(nums[i] - middleV);
		}
		return re;
	}
}
