package com.leetcode.java;

/**
 *
 *

 Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.

 *
 *
 * @author mengchaowang
 *
 */
public class Q053 {

  public int maxSubArray(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int prev = nums[0];
    int max = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int tmp = prev + nums[i] > nums[i] ? prev + nums[i] : nums[i];
      max = tmp > max ? tmp : max;
      prev = tmp;
    }
    return max;
  }
}
