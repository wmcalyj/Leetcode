package com.leetcode.java;

import java.util.ArrayList;
import java.util.List;

/**
 *

 Given a string representing an expression of fraction addition and subtraction, you need to return the calculation result in string format. The final result should be irreducible fraction. If your final result is an integer, say 2, you need to change it to the format of fraction that has denominator 1. So in this case, 2 should be converted to 2/1.

 Example 1:
 Input:"-1/2+1/2"
 Output: "0/1"
 Example 2:
 Input:"-1/2+1/2+1/3"
 Output: "1/3"
 Example 3:
 Input:"1/3-1/2"
 Output: "-1/6"
 Example 4:
 Input:"5/3+1/3"
 Output: "2/1"
 Note:
 The input string only contains '0' to '9', '/', '+' and '-'. So does the output.
 Each fraction (input and output) has format ±numerator/denominator. If the first input fraction or the output is positive, then '+' will be omitted.
 The input only contains valid irreducible fractions, where the numerator and denominator of each fraction will always be in the range [1,10]. If the denominator is 1, it means this fraction is actually an integer in a fraction format defined above.
 The number of given fractions will be in the range [1,10].
 The numerator and denominator of the final result are guaranteed to be valid and in the range of 32-bit int.

 * @author mengchaowang
 *
 */
public class Q592 {

  public class Fraction {

    public int sign;
    public int upper;
    public int lower;

    public Fraction(int sign, int upper, int lower) {
      this.sign = sign;
      this.upper = upper;
      this.lower = lower;
    }

    public Fraction() {
      this.sign = 1;
    }

    public Fraction add(Fraction f) {
      if (this.lower == f.lower) {
        int newUpper = this.upper * this.sign + f.upper * f.sign;
        if (newUpper < 0) {
          return new Fraction(-1, Math.abs(newUpper), f.lower);
        } else {
          return new Fraction(1, newUpper, f.lower);
        }
      } else {
        this.upper = this.upper * f.lower;
        f.upper = f.upper * this.lower;
        int newUpper = this.upper * this.sign + f.upper * f.sign;
        int newLower = this.lower * f.lower;
        if (newUpper < 0) {
          return new Fraction(-1, Math.abs(newUpper), newLower);
        } else {
          return new Fraction(1, newUpper, newLower);
        }
      }

    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      if (sign < 0) {
        sb.append("-");
      }
      return sb.append(upper).append("/").append(lower).toString();
    }

    public String reduce() {
      int gcd = gcd(this.upper, this.lower);
      this.upper /= gcd;
      this.lower /= gcd;
      if (this.upper == 0) {
        return "0/1";
      }
      return this.sign < 0 ? "-" + this.upper + "/" + this.lower : this.upper + "/" + this.lower;

    }
  }

  static int gcd(int a, int b) {
    if (a == 0 || b == 0) {
      return a + b; // base case
    }
    return gcd(b, a % b);
  }

  public String fractionAddition(String expression) {
    List<Fraction> processed = processExpression(expression);
    Fraction re = processed.get(0);
    for (int i = 1; i < processed.size(); i++) {
      re = re.add(processed.get(i));
    }
    return re.reduce();
  }

  private List<Fraction> processExpression(String expression) {
    List<Fraction> re = new ArrayList<Fraction>();
    Fraction f = new Fraction();
    StringBuilder sb = new StringBuilder();
    for (int i = expression.length() - 1; i >= 0; i--) {
      if (expression.charAt(i) == '+') {
        f.upper = Integer.parseInt(sb.toString());
        re.add(f);
        f = new Fraction();
        sb = new StringBuilder();
      } else if (expression.charAt(i) == '-') {
        f.upper = Integer.parseInt(sb.toString());
        f.sign = -1;
        re.add(f);
        f = new Fraction();
        sb = new StringBuilder();
      } else if (expression.charAt(i) == '/') {
        f.lower = Integer.parseInt(sb.toString());
        sb = new StringBuilder();
      } else {
        sb.insert(0, expression.charAt(i));
      }
    }

    if (expression.charAt(0) != '-') {
      f.upper = Integer.parseInt(sb.toString());
      re.add(f);
    }
    return re;
  }

  public static void main(String[] args) {
    Q592 q = new Q592();
    System.out.println(q.fractionAddition("-1/2+1/2"));
    System.out.println(q.fractionAddition("-1/2+1/2+1/3"));
    System.out.println(q.fractionAddition("1/3-1/2"));
    System.out.println(q.fractionAddition("5/3+1/3"));
  }
}
