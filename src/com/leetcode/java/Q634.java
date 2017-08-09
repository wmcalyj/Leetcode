package com.leetcode.java;

/**
 * Created by mengchaowang on 7/1/17.
 *

 In combinatorial mathematics, a derangement is a permutation of the elements of a set, such that no element appears in its original position.

 There's originally an array consisting of n integers from 1 to n in ascending order, you need to find the number of derangement it can generate.

 Also, since the answer may be very large, you should return the output mod 109 + 7.

 Example 1:
 Input: 3
 Output: 2
 Explanation: The original array is [1,2,3]. The two derangements are [2,3,1] and [3,1,2].


 */
public class Q634 {

  public int findDerangement(int n) {
    if (n <= 1) {
      return 0;
    }

    long prev = 0; // n = 1
    long current = 1; // n = 2
    for (int i = 3; i <= n; i++) {
      long tmp = current % ((int) Math.pow(10, 9) + 7);
      current = (i - 1) * (current + prev) % ((int) Math.pow(10, 9) + 7);
      prev = tmp % ((int) Math.pow(10, 9) + 7);
    }
    return (int) current % ((int) Math.pow(10, 9) + 7);
  }
}
