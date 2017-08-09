package com.leetcode.java;

/**
 *

 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.

 Show Company Tags
 Show Tags
 Show Similar Problems


 *
 * @author mengchaowang
 *
 */
public class Q153 {

  // O(n)
  public int findMin(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < nums[i - 1]) {
        return nums[i];
      }
    }
    return nums[0];
  }

  // O(logn)
  public int findMin2(int[] nums) {
    int l = 0;
    int r = nums.length - 1;
    return findMin2(nums, l, r);
  }

  public int findMin2(int[] nums, int i, int j) {
    int middle = (i + j) / 2;
    if (i >= j) {
      return nums[i];
    }
    if (nums[middle] > nums[i]) {
      return findMin2(nums, middle + 1, j);
    } else {
      return findMin2(nums, i, middle - 1);
    }
  }
}
