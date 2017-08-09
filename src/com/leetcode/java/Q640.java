package com.leetcode.java;
// @formatter:off

/**
 * Created by mengchaowang on 7/8/17.

Solve a given equation and return the value of x in the form of string "x=#value". The equation contains only '+', '-' operation, the variable x and its coefficient.

If there is no solution for the equation, return "No solution".

If there are infinite solutions for the equation, return "Infinite solutions".

If there is exactly one solution for the equation, we ensure that the value of x is an integer.

Example 1:
Input: "x+5-3+x=6+x-2"
Output: "x=2"
Example 2:
Input: "x=x"
Output: "Infinite solutions"
Example 3:
Input: "2x=x"
Output: "x=0"
Example 4:
Input: "2x+3x-6x=x+2"
Output: "x=-1"
Example 5:
Input: "x=x+2"
Output: "No solution"

 */

// @formatter:on
public class Q640 {

  public String solveEquation(String equation) {
    String[] strs = equation.split("=");
    String left = strs[0];
    String right = strs[1];
    // Position 0 is num of X, and 1 is number value
    int[] leftCounts = process(left);
    int[] rightCounts = process(right);
    int numOfX = leftCounts[0] - rightCounts[0];
    int numVal = rightCounts[1] - leftCounts[1];
    if (numOfX == 0 && numVal == 0) {
      return "Infinite solutions";
    }
    if (numOfX == 0 && numVal != 0) {
      return "No solution";
    }
    return "x=" + numVal / numOfX;
  }

  private int[] process(String expr) {
    int xCounts = 0;
    int num = 0;
    int signal = 1;
    int prev = 0;
    for (int i = 0; i < expr.length(); i++) {
      if (expr.charAt(i) == '+') {
        int[] subResult = processSubString(expr.substring(prev, i));
        prev = i + 1;
        xCounts = signal * subResult[0] + xCounts;
        num = signal * subResult[1] + num;
        signal = 1;
      }
      if (expr.charAt(i) == '-') {
        int[] subResult = processSubString(expr.substring(prev, i));
        prev = i + 1;
        xCounts = signal * subResult[0] + xCounts;
        num = signal * subResult[1] + num;
        signal = -1;
      }
    }
    int[] subResult = processSubString(expr.substring(prev, expr.length()));
    xCounts = signal * subResult[0] + xCounts;
    num = signal * subResult[1] + num;
    return new int[]{xCounts, num};
  }

  private int[] processSubString(String substring) {
    if (substring.endsWith("x")) {
      return new int[]{
          substring.length() == 1 ? 1 : Integer.parseInt(substring.substring(0, substring
              .length() - 1)),
          0};
    } else {
      return new int[]{0, substring.length() == 0 ? 0 : Integer.parseInt(substring)};
    }
  }
}
