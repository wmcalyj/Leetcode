package com.leetcode.java;

/**
 *

 Given a positive integer num, write a function which returns True if num is a perfect square else False.



 * @author mengchaowang
 *
 */
public class Q367 {

  public boolean isPerfectSquare(int num) {
    if (num == 0) {
      return true;
    }
    int start = 1;
    int end = num;
    int middle;
    while (start < end) {
      middle = (start + end) / 2;
      if (num / middle == middle && num % middle == 0) {
        return true;
      } else if (num / middle > middle) {
        start = middle + 1;
      } else {
        end = middle - 1;
      }
    }
    return (num / start == start && num % start == 0);
  }

  public static void main(String[] args) {
    Q367 q = new Q367();
    for (int i = 0; i < 100; i++) {
      System.out.println(i + ": " + q.isPerfectSquare(i));
    }
    System.out.println(q.isPerfectSquare(Integer.MAX_VALUE));
  }
}
