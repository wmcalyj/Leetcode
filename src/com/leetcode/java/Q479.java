package com.leetcode.java;
// @formatter:off

/**
 * Created by mengchaowang on 7/11/17.

Find the largest palindrome made from the product of two n-digit numbers.

Since the result could be very large, you should return the largest palindrome mod 1337.

Example:

Input: 2

Output: 987

Explanation: 99 x 91 = 9009, 9009 % 1337 = 987

Note:

The range of n is [1,8].

 */

// @formatter:on
public class Q479 {

//  public int largestPalindrome(int n) {
//    long max = (long) Math.pow(Math.pow(10, n) - 1, 2);
//    long min = (long) Math.pow(Math.pow(10, n - 1), 2);
//  }
//
//  public boolean isPalindrome(long num) {
//    String numStr = num + "";
//    int i = 0, j = numStr.length() - 1;
//    while (i <= j) {
//      if (
//          numStr.charAt(i++) != numStr.charAt(j--)) {
//        return false;
//      }
//    }
//    return true;
//  }
}
