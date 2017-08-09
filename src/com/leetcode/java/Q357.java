package com.leetcode.java;

/**
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 * <p>
 * Example:
 * Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
 *
 * @author mengchaowang
 */
public class Q357 {

  public int countNumbersWithUniqueDigits(int n) {
    int i = 0;
    int prev = 0;
    int result = 0;
    while (i < n) {
      prev = 9 * (i - 1);
      result = result + 9 * (i - 1);

    }
    return 0;
  }

}
