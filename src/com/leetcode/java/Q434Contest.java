package com.leetcode.java;

/**
 *
 *
 *

 Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

 For example,

 Input: "Hello, my name is John"

 Output: 5
 *
 *
 *
 * @author mengchaowang
 *
 */
public class Q434Contest {

  public int countSegments(String s) {
    return s == null || s.trim().isEmpty() ? 0 : s.trim().split("\\s+").length;

  }

  public static void main(String[] args) {
    Q434Contest q = new Q434Contest();
    String[] tests = {"a, bb, cc, cc#, ", "a", "Hello, my name is John", "    1    2 ",
        "1  2 3 33   456", "    ",
        "   1", "  2   ", " 3 "};
    for (String test : tests) {
      System.out.println(q.countSegments(test));
    }
  }
}
