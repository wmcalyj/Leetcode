package com.leetcode.java;
// @formatter:off

/**
 * Created by mengchaowang on 7/22/17.

Given a positive integer n, return the number of all possible attendance records with length n, which will be regarded as rewardable. The answer may be very large, return it after mod 109 + 7.

A student attendance record is a string that only contains the following three characters:

'A' : Absent.
'L' : Late.
'P' : Present.
A record is regarded as rewardable if it doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

Example 1:
Input: n = 2
Output: 8
Explanation:
There are 8 records with length 2 will be regarded as rewardable:
"PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
Only "AA" won't be regarded as rewardable owing to more than one absent times.

 */

// @formatter:on
public class Q552 {

  public int checkRecord(int n) {
    int[] ns = new int[100000];
    ns[0] = 0;
    ns[1] = 3;
    ns[2] = 8;
    for (int i = 3; i <= n; i++) {
      ns[i] = ns[i - 1] * 3 - ns[i - 2] - ns[i - 3];
    }
    return ns[n];

  }

}
