package com.leetcode.java;
// @formatter:off

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map; /**
 * Created by mengchaowang on 7/5/17.

In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.

For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings consisting of only 0s and 1s.

Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.

Note:
The given numbers of 0s and 1s will both not exceed 100
The size of given string array won't exceed 600.
Example 1:
Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
Output: 4

Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”
Example 2:
Input: Array = {"10", "0", "1"}, m = 1, n = 1
Output: 2

Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".

 */

// @formatter:on
public class Q474 {

  public int findMaxForm(String[] strs, int m, int n) {
    Map<String, int[]> strToCounts = preProcessStr(strs);
    Arrays.sort(strs, Comparator.comparingInt(String::length));
    return consume(strs, 0, m, n, strToCounts);
  }

  private Map<String, int[]> preProcessStr(String[] strs) {
    Map<String, int[]> re = new HashMap<>();
    for (String str : strs) {
      int[] counts = new int[2];
      for (int i = 0; i < str.length(); i++) {
        counts[str.charAt(i) - '0']++;
      }
      re.put(str, counts);
    }
    return re;
  }

  private int consume(String[] strs, int idx, int m, int n,
      Map<String, int[]> strToCounts) {
    if (idx >= strs.length) {
      return 0;
    }
    if (strs[idx].length() > m + n) {
      return 0;
    }
    String str = strs[idx];
    int[] counts = strToCounts.get(str);
    if (m - counts[0] < 0 || n - counts[1] < 0) {
      return consume(strs, idx + 1, m, n, strToCounts);
    } else {
      return Math.max(consume(strs, idx + 1, m - counts[0], n - counts[1], strToCounts) + 1,
          consume(strs, idx + 1, m, n, strToCounts));
    }
  }

  public static void main(String[] args) {
    String[][] tests = {
        {"11", "11", "0", "0", "10", "1", "1", "0", "11", "1", "0", "111", "11111000", "0", "11",
            "000", "1", "1", "0", "00", "1", "101", "001", "000", "0", "00", "0011", "0", "10000"},
        {"10", "0001", "111001", "1", "0"},
        {"10", "0001", "111001", "1", "0"},
        {"111", "1000", "1000", "1000"}};
    int[] m = {90, 5, 1, 9};
    int[] n = {66, 3, 1, 3};
    Q474 q = new Q474();
    for (int i = 0; i < tests.length; i++) {
      System.out.println(q.findMaxForm(tests[i], m[i], n[i]));
    }
  }

}
