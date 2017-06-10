package com.leetcode;

/**
 * 
  
 Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6. 
  
 * 
 * @author mengchaowang
 *
 */
public class Q152 {
	public int maxProduct(int[] nums) {
		int max = nums[0];
		int min = nums[0];
		int ans = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int mn = max, mi = min;
			max = Math.max(mn * nums[i], Math.max(nums[i], mi * nums[i]));
			min = Math.min(mi * nums[i], Math.min(nums[i], mn * nums[i]));
			ans = Math.max(ans, Math.max(max, min));
		}
		return ans;
	}

	public static void main(String[] args) {
		Q152 q = new Q152();
		int[][] nums = { { -2 }, { 1, 2, 3, 4 }, { 1, 0, 2, 3 }, { 1, -1, 2, 9 }, { 1, -1, 2, -9 }, { 4, -2, 2, 3 },
				{ -4, -3, -2 } };
		for (int i = 0; i < nums.length; i++) {
			System.out.println(q.maxProduct(nums[i]));
		}
	}
}
