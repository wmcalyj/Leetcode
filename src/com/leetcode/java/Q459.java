package com.leetcode.java;

/**
 *

 Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

 Example 1:
 Input: "abab"

 Output: True

 Explanation: It's the substring "ab" twice.
 Example 2:
 Input: "aba"

 Output: False
 Example 3:
 Input: "abcabcabcabc"

 Output: True

 Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)

 *
 * @author mengchaowang
 *
 */
public class Q459 {

  public boolean repeatedSubstringPattern(String str) {
    int totalLength = str.length();
    int half = totalLength / 2;
    for (int i = 1; i <= half; i++) {
      if (totalLength % i != 0) {
        continue;
      } else {
        int count = 0;
        int j = 0;
        while (count < totalLength) {
          if (j == i) {
            j = 0;
          }
          if (!(str.charAt(count) == str.charAt(j))) {
            break;
          } else {
            j++;
            count++;
          }
        }
        if (count == totalLength) {
          return true;
        }
      }
    }
    return false;
  }
}
