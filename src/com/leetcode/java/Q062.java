package com.leetcode.java;

/**
 *
 *

 A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

 How many possible unique paths are there?


 Above is a 3 x 7 grid. How many possible unique paths are there?

 Note: m and n will be at most 100.

 *
 * @author mengchaowang
 *
 */
public class Q062 {

  public int uniquePaths(int m, int n) {
    int[][] pos = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i != 0 && j != 0) {
          pos[i][j] = pos[i - 1][j] + pos[i][j - 1];
        } else {
          if (i == 0) {
            pos[i][j] = 1;
          } else if (j == 0) {
            pos[i][j] = 1;
          }
        }
      }
    }
    return pos[m - 1][n - 1];
  }
}
