package com.leetcode.java;
// @formatter:off

/**
 * Created by mengchaowang on 7/5/17.

Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.
Example 1:
Input:

0 0 0
0 1 0
0 0 0
Output:
0 0 0
0 1 0
0 0 0
Example 2:
Input:

0 0 0
0 1 0
1 1 1
Output:
0 0 0
0 1 0
1 2 1
Note:
The number of elements of the given matrix will not exceed 10,000.
There are at least one 0 in the given matrix.
The cells are adjacent in only four directions: up, down, left and right.

 */

// @formatter:on
public class Q542 {

  public int[][] updateMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        matrix[i][j] = findDistance(matrix, i, j);
      }
    }
    return matrix;
  }

  public int findDistance(int[][] matrix, int i, int j) {
    if (matrix[i][j] == 0) {
      return 0;
    } else {
      return checkSurroundings(matrix, i, j) + 1;
    }
  }

  private int checkSurroundings(int[][] matrix, int i, int j) {
    int min = Integer.MAX_VALUE;
    if (i - 1 >= 0) {
      if (matrix[i - 1][j] == 0) {
        min = Math.min(min, matrix[i - 1][j]);
      } else {
        min = Math.min(min, findDistance(matrix, i - 1, j));
      }
    }
    if (i + 1 < matrix.length) {
      if (matrix[i + 1][j] == 0) {
        min = Math.min(min, matrix[i + 1][j]);
      } else {
        min = Math.min(min, findDistance(matrix, i + 1, j));
      }
    }
    if (j - 1 >= 0) {
      if (matrix[i][j - 1] == 0) {
        min = Math.min(min, matrix[i][j - 1]);
      } else {
        min = Math.min(min, findDistance(matrix, i, j - 1));
      }
    }
    if (j + 1 < matrix[i].length) {
      if (matrix[i][j + 1] == 0) {
        min = Math.min(min, matrix[i][j + 1]);
      } else {
        min = Math.min(min, findDistance(matrix, i, j + 1));
      }
    }
    return min;
  }

  public static void main(String[] args) {
    int[][][] tests = {{
        {1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
        {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
        {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
        {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
        {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
        {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
        {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
        {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}}};
  }
}
