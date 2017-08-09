package com.leetcode.java;

/**
 *

 Given an array of integers, every element appears twice except for one. Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 *
 * @author mengchaowang
 *
 */
public class Q136 {

  public int singleNumber(int[] nums) {
    int r = nums[0];
    for (int i = 1; i < nums.length; i++) {
      r = r ^ nums[i];
    }
    return r;
  }
}
