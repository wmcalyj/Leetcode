package com.leetcode.java;

/**
 *

 Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order.

 Input:
 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 Output:  [1,2,4,7,5,3,6,8,9]


 * @author mengchaowang
 *
 */
public class Q498 {

  public int[] findDiagonalOrder(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return new int[0];
    }
    boolean up = true;
    // row, col
    int[] pos = {0, 0};
    int total = matrix.length * matrix[0].length;
    int[] re = new int[total];
    int mrows = matrix.length;
    int ncolumns = matrix[0].length;
    for (int i = 0; i < total; i++) {
      int x = pos[0];
      int y = pos[1];

      re[i] = matrix[x][y];
      if (up) {
        x--;
        y++;
        if (x < 0) {
          x = 0;
          up = false;
        }
        if (y >= ncolumns) {
          x += 2;
          y = ncolumns - 1;
          up = false;
        }
      } else {
        x++;
        y--;
        if (y < 0) {
          y = 0;
          up = true;
        }
        if (x >= mrows) {
          x = mrows - 1;
          y += 2;
          up = true;
        }

      }
      pos[0] = x;
      pos[1] = y;
    }
    return re;
  }

  public static void main(String[] args) {
    int[][][] cases = {

        {{1}, {2}, {3}, {4}}
    };
    Q498 q = new Q498();
    for (int[][] c : cases) {
      print(q.findDiagonalOrder(c));
    }
  }

  private static void print(int[] findDiagonalOrder) {
    StringBuilder sb = new StringBuilder("[");
    int i = 0;
    for (; i < findDiagonalOrder.length - 1; i++) {
      sb.append(findDiagonalOrder[i]).append(", ");
    }
    if (i < findDiagonalOrder.length) {
      sb.append(findDiagonalOrder[i]);
    }
    sb.append("]");
    System.out.println(sb.toString());
  }
}
