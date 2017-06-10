package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 
  
 We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.

Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.

Example 1:
Input: [1,3,2,2,5,2,3,7]
Output: 5
Explanation: The longest harmonious subsequence is [3,2,2,2,3]. 
  
  
 * 
 * @author mengchaowang
 *
 */
public class Q594 {
	public int findLHS(int[] nums) {
		Arrays.sort(nums);
		Map<Integer, Integer> map = new HashMap<>();
		Set<Integer> unique = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			int count = map.containsKey(nums[i]) ? map.get(nums[i]) + 1 : 1;
			map.put(nums[i], count);
			unique.add(nums[i]);
		}
		int[] sorted = new int[unique.size()];
		Iterator<Integer> it = unique.iterator();
		int i = 0;
		while (it.hasNext()) {
			sorted[i++] = it.next();
		}
		Arrays.sort(sorted);
		int max = 0;
		if (sorted.length == 1) {
			return 0;
		}
		for (i = 1; i < sorted.length; i++) {
			if (sorted[i] - sorted[i - 1] == 1) {
				max = Math.max(max, map.get(sorted[i]) + map.get(sorted[i - 1]));
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[][] tests = { { 1, 3, 1, 3, 2, 3, 0, 3, 0, 1, 2, 2, 2, -1, 2, 1, 0, 0, 2, 2, 3, -3, 1, 2, 2, 0, 1, 3, 1 } };
		Q594 q = new Q594();
		for (int[] test : tests) {
			System.out.println(q.findLHS(test));
		}
	}
}
