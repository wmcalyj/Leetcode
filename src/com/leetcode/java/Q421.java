package com.leetcode.java;

/**
 *
 *

 Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

 Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

 Could you do this in O(n) runtime?

 Example:

 Input: [3, 10, 5, 25, 2, 8]

 Output: 28

 Explanation: The maximum result is 5 ^ 25 = 28.

 *
 * @author mengchaowang
 *
 */
public class Q421 {

  public int findMaximumXOR(int[] nums) {
    int max = 0;
    int length = nums.length;
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length; j++) {
        if (i != j) {
          int re = nums[i] ^ nums[j];
          if (re > max) {
            max = re;
          }
        }
      }
    }
    return max;
  }

  public int findMaximumXOR_ON(int[] nums) {
    int min = Integer.MIN_VALUE;
    int zero = 0;
    for (int i = 0; i < nums.length; i++) {
      min = min & nums[i];
      zero = zero | nums[i];
    }
    return min ^ zero;

  }

  public static void main(String[] args) {
    System.out.println(3 ^ 10);
  }
}
