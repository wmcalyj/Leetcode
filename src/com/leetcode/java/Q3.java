package com.leetcode.java;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author mengchaowang
 *

For an integer n, we call k>=2 a good base of n, if all digits of n base k are 1.

Now given a string representing n, you should return the smallest good base of n in string format. 

Example 1:
Input: "13"
Output: "3"
Explanation: 13 base 3 is 111.
Example 2:
Input: "4681"
Output: "8"
Explanation: 4681 base 8 is 11111.
Example 3:
Input: "1000000000000000000"
Output: "999999999999999999"
Explanation: 1000000000000000000 base 999999999999999999 is 11.
Note:
The range of n is [3, 10^18].
The string representing n is always valid and will not have leading zeros.

 *
 */

public class Q3 {

  public String smallestGoodBase(String n) {
    BigDecimal k = new BigDecimal(2);
    BigDecimal nn = new BigDecimal(n);
    while (!nn.equals(BigDecimal.ZERO)) {
      while (nn.remainder(k).equals(BigDecimal.ONE)) {
        nn = nn.divide(k, RoundingMode.DOWN);
      }
      if (!nn.equals(BigDecimal.ZERO)) {
        k = k.add(BigDecimal.ONE);
        nn = new BigDecimal(n);
      }
    }
    return k.toString();
  }

  public static void main(String[] args) {
    Q3 q = new Q3();
    String[] tests = {"15", "13", "4681", "1000000000000000000"};
    for (String test : tests) {
      System.out.println(q.smallestGoodBase(test));
    }
  }

}
