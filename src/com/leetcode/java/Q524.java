package com.leetcode.java;

import java.util.List;

/**
 * Created by mengchaowang on 6/30/17.
 *
 *
 *

 Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

 Example 1:
 Input:
 s = "abpcplea", d = ["ale","apple","monkey","plea"]

 Output:
 "apple"
 Example 2:
 Input:
 s = "abpcplea", d = ["a","b","c"]

 Output:
 "a"
 Note:
 All the strings in the input will only contain lower-case letters.
 The size of the dictionary won't exceed 1,000.
 The length of all the strings in the input won't exceed 1,000.

 *
 *
 */
public class Q524 {

  public String findLongestWord(String s, List<String> d) {
    String re = "";
    for (String subStr : d) {
      if (stringContains(s, subStr)) {
        re = returnStr(re, subStr);
      }
    }
    return re;
  }

  private String returnStr(String re, String subStr) {
    if (re.length() != subStr.length()) {
      return re.length() > subStr.length() ? re : subStr;
    } else {
      return re.compareTo(subStr) <= 0 ? re : subStr;
    }
  }

  public boolean stringContains(String str, String subStr) {
    int i = 0, j = 0;
    while (i < str.length() && j < subStr.length() && str.length() - i >= subStr.length() - j) {
      if (str.charAt(i) == subStr.charAt(j)) {
        i++;
        j++;
      } else {
        i++;
      }
    }
    return j == subStr.length();
  }

}
