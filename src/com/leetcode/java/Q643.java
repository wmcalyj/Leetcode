package com.leetcode.java;
// @formatter:off

/**
 * Created by mengchaowang on 7/15/17.

Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.

Example 1:
Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
Note:
1 <= k <= n <= 30,000.
Elements of the given array will be in the range [-10,000, 10,000].

 */

// @formatter:on
public class Q643 {

  public double findMaxAverage(int[] nums, int k) {
    int start = 0, end = k - 1;
    double init = 0.0;
    for (int i = start; i <= end; i++) {
      init += nums[i];
    }
    double re = init / k;
    while (end < nums.length - 1) {
      init = init - nums[start++] + nums[++end];
      re = Math.max(re, init / k);
    }
    return re;
  }
}
