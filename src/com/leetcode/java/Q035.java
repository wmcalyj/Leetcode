package com.leetcode.java;

/**
 *

 Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 → 2
 [1,3,5,6], 2 → 1
 [1,3,5,6], 7 → 4
 [1,3,5,6], 0 → 0

 * @author mengchaowang
 *
 */
public class Q035 {

  public int searchInsert(int[] nums, int target) {
    if (nums.length == 0) {
      return 0;
    }
    return searchInsert(nums, 0, nums.length - 1, target);
  }

  private int searchInsert(int[] nums, int i, int j, int target) {
    // [1] 2
    // [1,3,5] 2
    if (i >= j) {
      if (target > nums[i]) {
        return i + 1;
      } else {
        return i;
      }
    }
    int middle = (i + j) / 2;
    if (nums[middle] == target) {
      return middle;
    }
    if (target > nums[middle]) {
      return searchInsert(nums, middle + 1, j, target);
    } else {
      return searchInsert(nums, i, middle - 1, target);
    }
  }
}
