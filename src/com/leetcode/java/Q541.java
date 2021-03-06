package com.leetcode.java;

/**
 *

 Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 Example:
 Input: s = "abcdefg", k = 2
 Output: "bacdfeg"
 Restrictions:
 The string consists of lower English letters only.
 Length of the given string and k will in the range [1, 10000]


 *
 * @author mengchaowang
 *
 */
public class Q541 {

  public String reverseStr(String s, int k) {
    StringBuilder sb = new StringBuilder();
    int i = 0;
    for (; i + 2 * k <= s.length(); i = i + 2 * k) {
      StringBuilder tmp = new StringBuilder(s.substring(i, i + k));
      tmp.reverse();
      sb.append(tmp);
      sb.append(s.substring(i + k, i + 2 * k));
    }
    if (i + k >= s.length()) {
      sb.append((new StringBuilder(s.substring(i))).reverse());
    } else if (i + k < s.length() && i + 2 * k > s.length()) {
      sb.append((new StringBuilder(s.substring(i, i + k))).reverse());
      i += k;
      sb.append(s.substring(i));
    }
    return sb.toString();
  }
}
