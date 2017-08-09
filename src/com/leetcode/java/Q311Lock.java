package com.leetcode.java;

/**
 *

 Given two sparse matrices A and B, return the result of AB.

 You may assume that A's column number is equal to B's row number.

 Example:

 A = [
 [ 1, 0, 0],
 [-1, 0, 3]
 ]

 B = [
 [ 7, 0, 0 ],
 [ 0, 0, 0 ],
 [ 0, 0, 1 ]
 ]


 |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
 AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
 | 0 0 1 |

 * @author mengchaowang
 *
 */
public class Q311Lock {

  public int[][] multiply(int[][] A, int[][] B) {
    int row = A.length;
    int col = B[0].length;
    int[][] result = new int[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (A[i][j] == 0) {
          continue;
        }
        for (int k = 0; k < col; k++) {
          if (B[k][i] == 0) {
            continue;
          }
          result[i][j] += A[i][k] * B[j][k];
          System.out.print(result[i][j]);
        }
      }
      System.out.println();
    }
    return result;
  }

  private int getResult(int[][] a, int[][] b, int i, int j) {
    int r = 0;
    for (int c = 0; c < a[i].length; c++) {
      // System.out.println("a[" + i + "][" + c + "] = " + a[i][c] + ",
      // b[" + c + "][" + j + "] = " + b[c][j]);
      r += a[i][c] * b[c][j];
    }
    return r;
  }

  public static void main(String[] args) {
    int[][] a = {{1, 0, 0}, {-1, 0, 3}};
    int[][] b = {{7, 0, 0}, {0, 0, 0}, {0, 0, 1}};
    Q311Lock q = new Q311Lock();
    q.multiply(a, b);
  }
}
