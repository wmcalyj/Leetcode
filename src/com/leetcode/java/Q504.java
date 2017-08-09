package com.leetcode.java;

/**
 *

 Given an integer, return its base 7 string representation.

 Example 1:
 Input: 100
 Output: "202"
 Example 2:
 Input: -7
 Output: "-10"
 Note: The input will be in range of [-1e7, 1e7].

 *
 * @author mengchaowang
 *
 */
public class Q504 {

  public String convertTo7(int num) {
    int re = 0;
    int count = 0;
    while (num != 0) {
      re += (int) (Math.pow(10, count++) * (num % 7));
      num /= 7;
    }
    return String.valueOf(re);
  }
}
