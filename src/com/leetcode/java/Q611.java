package com.leetcode.java;

import java.util.Arrays;

/**
 * Created by mengchaowang on 6/10/17.
 * <p>
 * <p>
 * Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
 * <p>
 * Example 1:
 * Input: [2,2,3,4]
 * Output: 3
 * Explanation:
 * Valid combinations are:
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 **/

public class Q611 {

  public int triangleNumber(int[] nums) {
    Arrays.sort(nums);
    int s1Idx = 0, s2Idx = 1, s3Idx = 2;
    int count = 0;
    for (s1Idx = 0; s1Idx < nums.length - 2; s1Idx++) {
      for (s2Idx = s1Idx + 1; s2Idx < nums.length - 1; s2Idx++) {
        for (s3Idx = s2Idx + 1; s3Idx < nums.length; s3Idx++) {
          if (nums[s1Idx] + nums[s2Idx] > nums[s3Idx]) {
            count++;
          } else {
            break;
          }
        }
      }
    }
    return count;
  }
}
