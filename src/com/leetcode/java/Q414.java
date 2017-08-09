package com.leetcode.java;

/**
 *

 Given an array of integers, return the 3rd Maximum Number in this array, if it doesn't exist, return the Maximum Number. The time complexity must be O(n) or less.


 * @author mengchaowang
 *
 */
public class Q414 {

  public int thirdMax(int[] nums) {
    if (nums == null || nums.length == 0) {
      return Integer.MIN_VALUE;
    }
    Integer[] max = new Integer[3];
    for (int i = 0; i < 3; i++) {
      max[i] = null;
    }
    for (int i = 0; i < nums.length; i++) {
      if (max[0] == null) {
        max[0] = nums[i];
      } else if (max[1] == null) {
        if (nums[i] == max[0]) {
          continue;
        }
        if (nums[i] > max[0]) {
          max[1] = nums[i];
        } else {
          max[1] = max[0];
          max[0] = nums[i];
        }
      } else if (max[2] == null) {
        if (nums[i] == max[1]) {
          continue;
        }
        if (nums[i] > max[1]) {
          max[2] = nums[i];
        } else {
          if (nums[i] == max[1] || nums[i] == max[0]) {
            continue;
          }
          if (nums[i] > max[0]) {
            max[2] = max[1];
            max[1] = nums[i];
          } else {
            max[2] = max[1];
            max[1] = max[0];
            max[0] = nums[i];
          }
        }
      } else {
        if (nums[i] == max[0] || nums[i] == max[1] || nums[i] == max[2]) {
          continue;
        }
        if (nums[i] < max[0]) {
          continue;
        } else if (nums[i] > max[2]) {
          max[0] = max[1];
          max[1] = max[2];
          max[2] = nums[i];
        } else {
          if (nums[i] > max[1]) {
            max[0] = max[1];
            max[1] = nums[i];
          } else if (nums[i] > max[0]) {
            max[0] = nums[i];
          }
        }
      }
    }
    if (max[2] != null) {
      return max[0];
    } else {
      if (max[1] != null) {
        return max[1];
      } else {
        return max[0];
      }
    }
  }
}
