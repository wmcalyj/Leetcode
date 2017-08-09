package com.leetcode.java;

/**
 *

 You are given a string representing an attendance record for a student. The record only contains the following three characters:

 'A' : Absent.
 'L' : Late.
 'P' : Present.
 A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

 You need to return whether the student could be rewarded according to his attendance record.

 Example 1:
 Input: "PPALLP"
 Output: True
 Example 2:
 Input: "PPALLL"
 Output: False

 *
 * @author mengchaowang
 *
 */
public class Q551 {

  public boolean checkRecord(String s) {
    int ls = 0;
    int as = 0;
    boolean previousL = false;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'A') {
        as++;
        if (as >= 2) {
          return false;
        }
      }
      if (s.charAt(i) == 'L') {
        if (previousL) {
          ls++;
          if (ls > 2) {
            return false;
          }
        } else {
          previousL = true;
          ls++;
        }
      }
      if (s.charAt(i) != 'L') {
        previousL = false;
        ls = 0;
      }
    }
    return true;

  }
}
