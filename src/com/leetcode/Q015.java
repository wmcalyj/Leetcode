package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
  
 Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
  
 * 
 * @author mengchaowang
 *
 */
public class Q015 {
	public List<List<Integer>> threeSum(int[] nums) {
		Set<Set<Integer>> results = new HashSet<Set<Integer>>();
		List<List<Integer>> trueResults = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					int a = nums[i];
					int b = nums[j];
					int c = nums[k];
					if (a + b + c == 0) {
						Set<Integer> solution = new HashSet<Integer>();
						solution.add(i);
						solution.add(j);
						solution.add(k);
						boolean valid = true;
						for (Set<Integer> result : results) {
							if (result.containsAll(solution)) {
								valid = false;
							}
						}
						if (valid) {
							List<Integer> trueResult = new ArrayList<Integer>();
							trueResult.add(a);
							trueResult.add(b);
							trueResult.add(c);
							trueResults.add(trueResult);
							results.add(solution);
						}
					}
				}
			}
		}
		return trueResults;
	}

	public void findSum(Map<Integer, Integer> all, int target) {

	}

}
