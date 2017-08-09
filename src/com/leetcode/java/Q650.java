package com.leetcode.java;
// @formatter:off

/**
 * Created by mengchaowang on 8/7/17.



 */

// @formatter:on
public class Q650 {

  public int minSteps(int n) {
    if (n == 1) {
      return 0;
    }
    int dividor = largetDividor(n);
    if (dividor == 1) {
      return n;
    }
    return dividor + minSteps(n / dividor);

  }

  public int largetDividor(int n) {
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        return i;
      }
    }
    return 1;
  }
}
