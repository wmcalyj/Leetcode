package com.leetcode.java;

/**
 *
 *

 Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

 Note:
 You must not modify the array (assume the array is read only).
 You must use only constant, O(1) extra space.
 Your runtime complexity should be less than O(n2).
 There is only one duplicate number in the array, but it could be repeated more than once.

 *
 * @author mengchaowang
 *
 */
public class Q287 {

  public int findDuplicate(int[] nums) {
    int n = nums.length - 1;
    int total = n * (n + 1) / 2;
    for (int i = 0; i <= n; i++) {
      total -= nums[i];
      if (total <= 0) {
        return nums[i];
      }
    }
    return nums[n];
  }
}
