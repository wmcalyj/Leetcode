package com.leetcode.java;

/**
 *
 *

 Follow up for "Unique Paths":

 Now consider if some obstacles are added to the grids. How many unique paths would there be?

 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 For example,
 There is one obstacle in the middle of a 3x3 grid as illustrated below.

 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 The total number of unique paths is 2.

 Note: m and n will be at most 100.

 *
 * @author mengchaowang
 *
 */
public class Q063 {

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    int[][] pos = new int[m][n];
    pos[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (obstacleGrid[i][j] == 1) {
          pos[i][j] = 0;
        } else {
          if (i == 0) {
            if (j == 0) {
              continue;
            }
            pos[i][j] = pos[i][j - 1];
          } else if (j == 0) {
            if (i == 0) {
              continue;
            }
            pos[i][j] = pos[i - 1][j];
          } else {
            pos[i][j] = pos[i - 1][j] + pos[i][j - 1];
          }
        }
      }
    }
    return pos[m - 1][n - 1];
  }
}
