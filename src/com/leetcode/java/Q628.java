package com.leetcode.java;

import java.util.Arrays;

/**
 * Created by mengchaowang on 6/24/17.
 * <p>
 * <p>
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
 * <p>
 * Example 1:
 * Input: [1,2,3]
 * Output: 6
 * Example 2:
 * Input: [1,2,3,4]
 * Output: 24
 */
public class Q628 {

  public int maximumProduct(int[] nums) {
    Arrays.sort(nums);
    int max1 = nums[0] * nums[1] * nums[nums.length - 1];
    int max2 = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
    return Integer.max(max1, max2);

  }
}
