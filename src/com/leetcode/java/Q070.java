package com.leetcode.java;

import java.util.HashMap;
import java.util.Map;

/**
 *

 You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 *
 * @author mengchaowang
 *
 */
public class Q070 {

  Map<Integer, Integer> cache = new HashMap<Integer, Integer>();

  public int climbStairs(int n) {
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }
    Integer one = null, two = null;
    one = cache.containsKey(n - 1) ? cache.get(n - 1) : climbStairs(n - 1);
    two = cache.containsKey(n - 2) ? cache.get(n - 2) : climbStairs(n - 2);
    cache.put(n - 1, one);
    cache.put(n - 2, two);
    return one + two;
  }
}
