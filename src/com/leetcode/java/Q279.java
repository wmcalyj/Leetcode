package com.leetcode.java;

import java.util.HashMap;
import java.util.Map;

// @formatter:off

/**
 * Created by mengchaowang on 7/3/17.

Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

 */

// @formatter:on
public class Q279 {

  public int numSquares(int n) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(1, 1);
    for (int i = 2; i <= n; i++) {
      int min = Integer.MAX_VALUE;
      for (int j = 1; j <= i / 2; j++) {
        min = Integer.min(min, map.get(j) + map.get(i - j));
      }
      if (IsPerfectSquare(i)) {
        map.put(i, 1);
      } else {
        map.put(i, min);
      }
    }
    return map.get(n);
  }

  boolean IsPerfectSquare(long input) {
    long closestRoot = (long) Math.sqrt(input);
    return input == closestRoot * closestRoot;
  }
}
