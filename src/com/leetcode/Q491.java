package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * 
 Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2 .

Example:
Input: [4, 6, 7, 7]
Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
Note:
The length of the given array will not exceed 15.
The range of integer in the given array is [-100,100].
The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence. 

  
 * 
 * @author mengchaowang
 *
 */
public class Q491 {
	public List<List<Integer>> findSubsequences(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new ArrayList<List<Integer>>();
		}
		List<List<Integer>> re = new ArrayList<List<Integer>>();
		Set<Integer> used = new HashSet<>();
		for (int i = 0; i < nums.length - 1; i++) {
			if (used.contains(nums[i])) {
				continue;
			} else {
				used.add(nums[i]);
				List<Integer> sre = new ArrayList<>();
				sre.add(nums[i]);
				findSubSequences(nums, i, sre, re);
			}
		}
		return re;
	}

	private void findSubSequences(int[] nums, int i, List<Integer> sre, List<List<Integer>> re) {
		if (i == nums.length - 1) {
			return;
		}
		Set<Integer> checked = new HashSet<>();
		for (int j = i + 1; j < nums.length; j++) {
			if (checked.contains(nums[j])) {
				continue;
			} else {
				if (nums[j] >= sre.get(sre.size() - 1)) {
					List<Integer> newSre = new ArrayList<>(sre);
					newSre.add(nums[j]);
					re.add(new ArrayList<Integer>(newSre));
					checked.add(nums[j]);
					findSubSequences(nums, j, new ArrayList<Integer>(newSre), re);
				}
			}
		}
	}
}
