package com.leetcode.java;
// @formatter:off

/**
 * Created by mengchaowang on 7/22/17.

The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.

Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.

Example 1:
Input: nums = [1,2,2,4]
Output: [2,3]
Note:
The given array size will in the range [2, 10000].
The given array's numbers won't have any order.

 */

// @formatter:on
public class Q645 {

  public int[] findErrorNums(int[] nums) {
    int[] re = new int[2];
    int[] tmp = new int[nums.length + 1];
    for (int num : nums) {
      tmp[num]++;
    }
    for (int i = 1; i < tmp.length; i++) {
      if (tmp[i] == 2) {
        re[0] = i;
      } else if (tmp[i] == 0) {
        re[1] = i;
      }
    }
    return re;
  }
}
