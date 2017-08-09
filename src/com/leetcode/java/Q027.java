package com.leetcode.java;

/**
 *

 Given an array and a value, remove all instances of that value in place and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.

 Example:
 Given input array nums = [3,2,2,3], val = 3

 Your function should return length = 2, with the first two elements of nums being 2.

 * @author mengchaowang
 *
 */
public class Q027 {

  public int removeElement(int[] nums, int val) {
    int i = 0, j = nums.length - 1;
    int length = nums.length;
    while (i < j) {
      while (j >= 0 && nums[j] == val) {
        j--;
        length--;
      }
      if (i >= j || j < 0) {
        return length;
      }
      if (nums[i] == val) {
        nums[i] = nums[j];
        length--;
        j--;
      }
      i++;
    }
    if (j >= 0 && nums[j] == val) {
      return length - 1;
    }
    return length;
  }
}
