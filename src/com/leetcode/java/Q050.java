package com.leetcode.java;

/**
 *
 *
 Implement pow(x, n). 
 *
 *
 * @author mengchaowang
 *
 */
public class Q050 {

  public double myPow(double x, int n) {
    boolean negative = n < 0;
    String binary = Integer.toBinaryString(Math.abs(n));
    double current = x;
    double result = 1;

    for (int i = binary.length() - 1; i >= 0; i--) {
      if (binary.charAt(i) == '1') {
        result *= current;
      }
      current *= current;

    }
    return negative ? 1 / result : result;
  }

  public static void main(String[] args) {
    Q050 q = new Q050();
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        System.out.println(q.myPow(i, j));
      }
    }
  }
}
