package com.leetcode.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q532 {

  public int findPairs(int[] nums, int k) {
    Set<Integer> used = new HashSet<>();
    if (nums.length == 0) {
      return 0;
    }
    Arrays.sort(nums);
    int count = 0;
    int last = nums[nums.length - 1];
    for (int i = 0; i < nums.length - 1; i++) {

      if (last - nums[i] < k) {
        return count;
      }
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] - nums[i] == k) {
          if (!used.contains(nums[i])) {
            count++;
            used.add(nums[i]);
          }
        } else if (Math.abs(nums[i] - nums[j]) > k) {
          break;
        }
      }
    }

    return count;
  }
}
