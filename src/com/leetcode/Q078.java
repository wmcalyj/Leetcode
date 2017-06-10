package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
  
 Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
] 
  
 * 
 * 
 * @author mengchaowang
 *
 */
public class Q078 {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		calculateSubset(nums, result, new ArrayList<Integer>(), 0);
		return result;
	}

	public void calculateSubset(int[] nums, List<List<Integer>> result, List<Integer> tmpResult, int index) {
		if (index == nums.length) {
			result.add(tmpResult);
			return;
		}
		// Add current number
		List<Integer> t1 = new ArrayList<Integer>(tmpResult);
		List<Integer> t2 = new ArrayList<Integer>(tmpResult);
		t2.add(nums[index]);
		calculateSubset(nums, result, t1, index + 1);
		calculateSubset(nums, result, t2, index + 1);

	}
}
