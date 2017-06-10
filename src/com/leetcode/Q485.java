package com.leetcode;

/**
 * 
 * 
  
 Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000 
  
 * 
 * 
 * @author mengchaowang
 *
 */
public class Q485 {
	public int findMaxConsecutiveOnes(int[] nums) {
		int max = 0;
		int tmpMax = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				max = tmpMax > max ? tmpMax : max;
				tmpMax = 0;
			} else {
				tmpMax++;
			}
		}
		max = tmpMax > max ? tmpMax : max;
		return max;
	}

	public static void main(String[] args) {
		int[][] cases = { { 1, 1, 0, 1, 1, 1 }, { 1 }, { 0 }, { 1, 1, 1, 1 } };
		Q485 q = new Q485();
		for (int[] oneCase : cases) {
			System.out.println(q.findMaxConsecutiveOnes(oneCase));
		}
	}
}
