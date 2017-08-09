package com.leetcode.java;

/**
 *

 There is an m by n grid with a ball. Given the start coordinate (i,j) of the ball, you can move the ball to adjacent cell or cross the grid boundary in four directions (up, down, left, right). However, you can at most move N times. Find out the number of paths to move the ball out of grid boundary. The answer may be very large, return it after mod 109 + 7.

 Example 1:
 Input:m = 2, n = 2, N = 2, i = 0, j = 0
 Output: 6
 Explanation:

 Example 2:
 Input:m = 1, n = 3, N = 3, i = 0, j = 1
 Output: 12
 Explanation:

 Note:
 Once you move the ball out of boundary, you cannot move it back.
 The length and height of the grid is in range [1,50].
 N is in range [0,50].

 *
 * @author mengchaowang
 *
 */
public class Q576 {

  public int findPaths(int m, int n, int N, int i, int j) {
    long total = 0;
    total += getPaths(m, n, N, i, j);
    return (int) (total % (Math.pow(10, 9) + 7));
  }

  public long getPaths(int m, int n, int N, int i, int j) {
    if (N <= 0 || i < 0 || j < 0 || i >= m || j >= n) {
      return 0;
    }
    long total = 0;
    if (i == 0 || i == m - 1) {
      total++;
      total += getPaths(m, n, N - 1, i + 1, j) + getPaths(m, n, N - 1, i - 1, j);
    }
    if (j == 0 || j == n - 1) {
      total++;
      total += getPaths(m, n, N - 1, i, j - 1) + getPaths(m, n, N - 1, i, j + 1);
    }

    if (i != 0 && i != m - 1 && j != 0 && j != n - 1) {
      total += getPaths(m, n, N - i, 0, j);
      total += getPaths(m, n, N - (m - i), m - 1, j);
      total += getPaths(m, n, N - j, i, 0);
      total += getPaths(m, n, N - (n - j), i, n - 1);
    } else {
      total +=
          getPaths(m, n, N - 1, i + 1, j) + getPaths(m, n, N - 1, i - 1, j) + getPaths(m, n, N - 1,
              i, j - 1)
              + getPaths(m, n, N - 1, i, j + 1);
    }
    return total;
  }
}
