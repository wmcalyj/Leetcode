package com.leetcode.java;

/**
 *

 There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

 The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

 Note:
 All costs are positive integers.

 *
 * @author mengchaowang
 *
 */
public class Q256Lock {

  public int minCost(int[][] costs) {
    if (costs.length == 0) {
      return 0;
    }
    int minR = costs[0][0];
    int minB = costs[0][1];
    int minG = costs[0][2];
    for (int i = 1; i < costs.length; i++) {
      System.out.println("minR - " + minR + ", minB - " + minB + ", minG - " + minG);
      int tmpR = minR, tmpB = minB, tmpG = minG;
      minR = Math.min(tmpB + costs[i][0], tmpG + costs[i][0]);
      minB = Math.min(tmpR + costs[i][1], tmpG + costs[i][1]);
      minG = Math.min(tmpR + costs[i][2], tmpB + costs[i][2]);
    }
    return Math.min(minR, Math.min(minB, minG));
  }

  public static void main(String[] args) {
    Q256Lock q = new Q256Lock();
    int[][][] costs = {{{17, 2, 17}, {16, 16, 5}, {14, 3, 19}}, {{10, 50, 100}, {1, 2, 3}}, {{}}};
    for (int i = 0; i < costs.length; i++) {
      System.out.println(q.minCost(costs[i]));
    }
  }

}
