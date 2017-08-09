package com.leetcode.java;
// @formatter:off

/**
 * Created by mengchaowang on 7/22/17.

Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

 */

// @formatter:on
public class Q647 {

  public int countSubstrings(String s) {
    int length = s.length();
    int size = 1;
    int re = 0;
    while (size <= length) {
      for (int i = 0; i <= length - size; i++) {
        if (checkPalindromic(s.substring(i, i + size))) {
          re++;
        }
      }
      size++;
    }
    return re;

  }

  public boolean checkPalindromic(String s) {
    if (s == null || s.isEmpty() || s.length() == 0) {
      return false;
    }
    int i = 0;
    int j = s.length() - 1;
    while (i < j) {
      if (s.charAt(i++) != s.charAt(j--)) {
        return false;
      }
    }
    if (s.charAt(i) != s.charAt(j)) {
      return false;
    }
    return true;
  }
}
