package com.leetcode.java;

import java.util.ArrayList;
import java.util.List;

/**
 *

 Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

 Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

 Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

 Note:
 The order of returned grid coordinates does not matter.
 Both m and n are less than 150.
 Example:

 Given the following 5x5 matrix:

 Pacific ~   ~   ~   ~   ~
 ~  1   2   2   3  (5) *
 ~  3   2   3  (4) (4) *
 ~  2   4  (5)  3   1  *
 ~ (6) (7)  1   4   5  *
 ~ (5)  1   1   2   4  *
 *   *   *   *   * Atlantic

 Return:

 [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).

 * @author mengchaowang
 *
 */
public class Q417Contest {

  public List<int[]> pacificAtlantic(int[][] matrix) {
    List<int[]> result = new ArrayList<int[]>();
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return result;
    }
    Boolean[][] pacificBool = new Boolean[matrix.length][matrix[0].length];
    Boolean[][] atlanticBool = new Boolean[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        pacificBool[i][j] = null;
        atlanticBool[i][j] = null;
      }
    }
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (canGoToAtlantic(atlanticBool, matrix, i, j) && canGoToPacific(pacificBool, matrix, i,
            j)) {
          int[] pos = new int[2];
          pos[0] = i;
          pos[1] = j;
          result.add(pos);
        }
      }
    }
    return result;
  }

  private boolean canGoToAtlantic(Boolean[][] atlanticBool, int[][] matrix, int i, int j) {
    if (atlanticBool[i][j] != null) {
      return atlanticBool[i][j];
    }
    if (i == 0 || j == 0) {
      atlanticBool[i][j] = true;
      return true;
    }
    int m = matrix.length - 1;
    int n = matrix[m].length - 1;
    boolean up =
        matrix[i - 1][j] < matrix[i][j] ? canGoToAtlantic(atlanticBool, matrix, i - 1, j) : false;
    if (matrix[i - 1][j] == matrix[i][j]) {
      matrix[i][j]++;
      up = canGoToAtlantic(atlanticBool, matrix, i - 1, j);
      matrix[i][j]--;
    }
    boolean down =
        i < m && matrix[i + 1][j] < matrix[i][j] ? canGoToAtlantic(atlanticBool, matrix, i + 1, j)
            : false;
    if (i < m && matrix[i + 1][j] == matrix[i][j]) {
      matrix[i][j]++;
      down = canGoToAtlantic(atlanticBool, matrix, i + 1, j);
      matrix[i][j]--;
    }
    boolean left =
        matrix[i][j - 1] < matrix[i][j] ? canGoToAtlantic(atlanticBool, matrix, i, j - 1) : false;
    if (matrix[i][j - 1] == matrix[i][j]) {
      matrix[i][j]++;
      left = canGoToAtlantic(atlanticBool, matrix, i, j - 1);
      matrix[i][j]--;
    }
    boolean right =
        j < n && matrix[i][j + 1] < matrix[i][j] ? canGoToAtlantic(atlanticBool, matrix, i, j + 1)
            : false;
    if (j < n && matrix[i][j + 1] == matrix[i][j]) {
      matrix[i][j]++;
      right = canGoToAtlantic(atlanticBool, matrix, i, j + 1);
      matrix[i][j]--;
    }
    boolean result = up || down || left || right;
    if (result) {
      atlanticBool[i][j] = true;
    }
    return result;

  }

  private boolean canGoToPacific(Boolean[][] pacificBool, int[][] matrix, int i, int j) {
    if (pacificBool[i][j] != null) {
      return pacificBool[i][j];
    }
    int m = matrix.length - 1;
    int n = matrix[m].length - 1;
    if (i == m || j == n) {
      pacificBool[i][j] = true;
      return true;
    }
    boolean up =
        i > 0 && matrix[i - 1][j] < matrix[i][j] ? canGoToPacific(pacificBool, matrix, i - 1, j)
            : false;
    if (i > 0 && matrix[i - 1][j] == matrix[i][j]) {
      matrix[i][j]++;
      up = canGoToPacific(pacificBool, matrix, i - 1, j);
      matrix[i][j]--;
    }
    boolean down =
        matrix[i + 1][j] < matrix[i][j] ? canGoToPacific(pacificBool, matrix, i + 1, j) : false;
    if (matrix[i + 1][j] == matrix[i][j]) {
      matrix[i][j]++;
      down = canGoToPacific(pacificBool, matrix, i + 1, j);
      matrix[i][j]--;
    }
    boolean left =
        j > 0 && matrix[i][j - 1] < matrix[i][j] ? canGoToPacific(pacificBool, matrix, i, j - 1)
            : false;
    if (j > 0 && matrix[i][j - 1] == matrix[i][j]) {
      matrix[i][j]++;
      left = canGoToPacific(pacificBool, matrix, i, j - 1);
      matrix[i][j]--;
    }
    boolean right =
        matrix[i][j + 1] < matrix[i][j] ? canGoToPacific(pacificBool, matrix, i, j + 1) : false;
    if (matrix[i][j + 1] == matrix[i][j]) {
      matrix[i][j]++;
      right = canGoToPacific(pacificBool, matrix, i, j + 1);
      matrix[i][j]--;
    }
    boolean result = up || down || left || right;
    if (result) {
      pacificBool[i][j] = true;
    }
    return result;
  }

  public static void main(String[] args) {
    Q417Contest q = new Q417Contest();
    int[][][] matrix = {
        {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}},
        {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}}};
    for (int i = 0; i < matrix.length; i++) {
      List<int[]> result = q.pacificAtlantic(matrix[i]);
      System.out.println("==========================");
      for (int[] r : result) {
        System.out.println(r[0] + ", " + r[1]);
      }
    }
  }
}
