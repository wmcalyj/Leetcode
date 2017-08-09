package com.leetcode.java;

/**
 *

 Given an array of integers, every element appears three times except for one. Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 * @author mengchaowang
 *
 */
public class Q137 {

  public int singleNumber(int[] nums) {
    int r1 = 0;
    int r2 = 0;
    for (int i = 0; i < nums.length; i++) {
      r1 ^= ~nums[i];
      r2 ^= nums[i];
    }
    return r1 ^ r2;
  }

  public static void main(String[] args) {
    Q137 q = new Q137();
    System.out.println(q.singleNumber(new int[]{1, 1, 1, 2, 2, 2, 5, 5, 5, 6}));
  }
}
