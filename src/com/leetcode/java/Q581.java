package com.leetcode.java;

import java.util.Arrays;

/**
 *

 Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

 You need to find the shortest such subarray and output its length.

 Example 1:
 Input: [2, 6, 4, 8, 10, 9, 15]
 Output: 5
 Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 Note:
 Then length of the input array is in range [1, 10,000].
 The input array may contain duplicates, so ascending order here means <=.

 *
 * @author mengchaowang
 *
 */
public class Q581 {

  public int findUnsortedSubarray(int[] nums) {
    int[] sorted = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      sorted[i] = nums[i];
    }
    Arrays.sort(sorted);
    int start = 0;
    int end = nums.length - 1;
    while (start < nums.length && sorted[start] == nums[start]) {
      start++;
    }
    while (end >= 0 && sorted[end] == nums[end]) {
      end--;
    }
    if (end < start) {
      return 0;
    }
    return end - start + 1;
  }
}
