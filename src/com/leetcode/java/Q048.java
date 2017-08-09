package com.leetcode.java;

/**
 *

 You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 Follow up:
 Could you do this in-place?

 *
 * @author mengchaowang
 *
 */
public class Q048 {

  public void rotate(int[][] matrix) {
    int size = matrix.length;
    int[][] tmp = new int[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        tmp[j][size - 1 - i] = matrix[i][j];
      }
    }
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        matrix[i][j] = tmp[i][j];
      }
    }
  }

  // In place solution
  public void rotate2(int[][] matrix) {
    rotate(0, matrix.length - 1, matrix);
  }

  public void rotate(int start, int end, int[][] matrix) {
    if (start >= end) {
      return;
    }
    int tmp;
    for (int i = start; i < end; i++) {
      tmp = matrix[start][i];
      matrix[start][i] = matrix[end - i + start][start];
      matrix[end - i + start][start] = matrix[end][end - i + start];
      matrix[end][end - i + start] = matrix[i][end];
      matrix[i][end] = tmp;
    }
    rotate(start + 1, end - 1, matrix);
  }

  public static void main(String[] args) {
    int[][] test = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    Q048 q = new Q048();
    q.rotate2(test);
  }
}
