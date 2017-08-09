package com.leetcode.java;

/**
 * Created by mengchaowang on 7/1/17.

 Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.

 Example 1:
 Input: 5
 Output: True
 Explanation: 1 * 1 + 2 * 2 = 5
 Example 2:
 Input: 3
 Output: False

 */
public class Q633 {

  public boolean judgeSquareSum(int c) {
    int bound = (int) Math.sqrt(c);
    for (int i = 0; i <= bound; i++) {
      int b = (int) Math.sqrt(c - i * i);
      if (b * b + i * i == c) {
        return true;
      }
    }
    return false;
  }
}
