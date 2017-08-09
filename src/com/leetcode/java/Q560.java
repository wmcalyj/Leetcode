package com.leetcode.java;

/**
 *
 *

 Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

 Example 1:
 Input:nums = [1,1,1], k = 2
 Output: 2
 Note:
 The length of the array is in range [1, 20,000].
 The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].


 *
 * @author mengchaowang
 *
 */
public class Q560 {

  public int subarraySum(int[] nums, int k) {
    int re = 0;
    if (nums[0] == k) {
      re++;
    }
    for (int i = 1; i < nums.length; i++) {
      nums[i] += nums[i - 1];
      if (nums[i] == k) {
        re++;
      }
    }
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] - nums[i] == k) {
          re++;
        }
      }
    }
    return re;
  }
}
