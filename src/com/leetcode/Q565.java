package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 
  
 A zero-indexed array A consisting of N different integers is given. The array contains all integers in the range [0, N - 1].

Sets S[K] for 0 <= K < N are defined as follows:

S[K] = { A[K], A[A[K]], A[A[A[K]]], ... }.

Sets S[K] are finite for each K and should NOT contain duplicates.

Write a function that given an array A consisting of N integers, return the size of the largest set S[K] for this array.

Example 1:
Input: A = [5,4,0,3,1,6,2]
Output: 4
Explanation: 
A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.

One of the longest S[K]:
S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
Note:
N is an integer within the range [1, 20,000].
The elements of A are all distinct.
Each element of array A is an integer within the range [0, N-1].
 
  
  
 * 
 * @author mengchaowang
 *
 */
public class Q565 {
	public int arrayNesting(int[] nums) {
		int max = 0;
		Set<Integer> visited = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			Set<Integer> tmp = new HashSet<>();
			if (!visited.contains(i)) {
				startLoop(i, tmp, nums);
				if (tmp.size() > nums.length / 2) {
					return tmp.size();
				}
				max = Math.max(max, tmp.size());
			}
			visited.addAll(tmp);
		}
		return max;
	}

	private void startLoop(final int i, Set<Integer> tmp, int[] nums) {
		int idx = i;
		while (!tmp.contains(nums[idx])) {
			tmp.add(nums[idx]);
			idx = nums[nums[idx]];
		}
	}

	public static void main(String[] args) {
		int[] test = { 5, 4, 0, 3, 6, 2 };
		Q565 q = new Q565();
		System.out.println(q.arrayNesting(test));
	}
}
