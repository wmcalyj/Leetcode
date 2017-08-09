package com.leetcode.java;

/**
 *

 Given a 01 matrix M, find the longest line of consecutive one in the matrix. The line could be horizontal, vertical, diagonal or anti-diagonal.

 Example:
 Input:
 [[0,1,1,0],
 [0,1,1,0],
 [0,0,0,1]]
 Output: 3
 Hint: The number of elements in the given matrix will not exceed 10,000.

 * @author mengchaowang
 *
 */
public class Q562 {

  public int longestLine(int[][] M) {
    int max = 0;
    for (int i = 0; i < M.length; i++) {
      for (int j = 0; j < M[i].length; j++) {
        int h = 0, v = 0, d = 0, ad = 0;
        if (M[i][j] == 0) {
          continue;
        }
        if ((M[i][j] >> 1 & 1) != 1) {
          h = horizontal(M, i, j); // 10
        }
        if ((M[i][j] >> 2 & 1) != 1) {
          v = vertical(M, i, j); // 100
        }
        if ((M[i][j] >> 3 & 1) != 1) {
          d = diagonal(M, i, j); // 1000
        }
        if ((M[i][j] >> 4 & 1) != 1) {
          ad = antiDiagonal(M, i, j); // 10000
        }
        int tmpMax = Math.max(Math.max(h, v), Math.max(d, ad));
        if (tmpMax > max) {
          max = tmpMax;
        }
      }
    }
    return max;

  }

  public int horizontal(int[][] M, int i, int j) {
    int count = 0;
    while (j < M[i].length && (M[i][j] & 1) == 1) {
      count++;
      M[i][j] = M[i][j] | 2;
      j++;
    }
    return count;
  }

  public int vertical(int[][] M, int i, int j) {
    int count = 0;
    while (i < M.length && (M[i][j] & 1) == 1) {
      count++;
      M[i][j] = M[i][j] | 4;
      i++;
    }
    return count;
  }

  public int diagonal(int[][] M, int i, int j) {
    int count = 0;
    while (i < M.length && j < M[i].length && (M[i][j] & 1) == 1) {
      count++;
      M[i][j] = M[i][j] | 8;
      i++;
      j++;
    }
    return count;
  }

  public int antiDiagonal(int[][] M, int i, int j) {
    int count = 0;
    while (i < M.length && j >= 0 && (M[i][j] & 1) == 1) {
      count++;
      M[i][j] = M[i][j] | 16;
      i++;
      j--;
    }
    return count;
  }
}
