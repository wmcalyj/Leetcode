package com.leetcode.java;
// @formatter:off

/**
 * Created by mengchaowang on 7/23/17.

Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?



 */

// @formatter:on
public class Q300 {

  public int lengthOfLIS(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return 1;
    }
    int[] cache = new int[nums.length];
    int re = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      re = Math.max(re, findLength(nums, nums[i], i, i + 1, 1, cache));
    }
    return re;

  }

  private int findLength(int[] nums, int currentNum, int currentIdx, int nextIdx, int tmpLength,
      int[] cache) {
    if (currentIdx >= nums.length || nextIdx >= nums.length) {
      return tmpLength;
    }
    if (cache[nextIdx] != 0 && nums[nextIdx] > currentNum) {
      return tmpLength + cache[nextIdx];
    }
    int pick = 0;
    if (nums[nextIdx] > currentNum) {
      pick = findLength(nums, nums[nextIdx], nextIdx, nextIdx + 1, tmpLength + 1, cache) + 1;
    }
    int noPick = findLength(nums, currentNum, nextIdx, nextIdx + 1, tmpLength, cache);
    int re = Math.max(pick, noPick);
    cache[currentIdx] = re;
    return re;

  }


}
