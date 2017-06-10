package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * 
  
 Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3] 
  
 * 
 */
public class Q442 {
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();

		for (int i = 0, j = nums.length; i < j; i++) {
			int idx = Math.abs(nums[i]);
			if (nums[idx - 1] < 0) {
				result.add(idx);
			} else {
				nums[idx - 1] = -nums[idx - 1];
			}

		}

		return result;
	}

	public static void main(String[] args) {
		Q442 q = new Q442();
		int[][] cases = { { 5, 4, 6, 7, 9, 3, 10, 9, 5, 6 }, { 4, 3, 2, 7, 8, 2, 3, 1 }, { 1, 1, 2, 3, 4, 5, 6 } };
		for (int[] oneCase : cases) {
			System.out.println(q.findDuplicates(oneCase));
		}
	}
}
