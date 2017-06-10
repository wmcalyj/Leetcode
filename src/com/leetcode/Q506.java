package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
  
 Given scores of N athletes, find their relative ranks and the men with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

Example 1:
Input: [5, 4, 3, 2, 1]
Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal". 
For the left two athletes, you just need to output their relative ranks according to their scores.
Note:
N is a positive integer and won't exceed 10,000.
All the sores of athletes are ensure to be unique. 
  
  
 * @author mengchaowang
 *
 */
public class Q506 {

	public String[] findRelativeRanks(int[] nums) {
		// Score, Pos
		String[] re = new String[nums.length];
		Map<Integer, Integer> scorePos = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			scorePos.put(nums[i], i);
		}
		Arrays.sort(nums);
		for (int i = 0, j = nums.length; i < j; i++) {
			int rank = i + 1;
			int pos = scorePos.get(nums[j - i - 1]);
			String award;
			switch (rank) {
			case 1:
				award = "Gold Medal";
				break;
			case 2:
				award = "Silver Medal";
				break;
			case 3:
				award = "Bronze Medal";
				break;
			default:
				award = "" + rank;
				break;
			}
			re[pos] = award;
		}
		return re;
	}
}
