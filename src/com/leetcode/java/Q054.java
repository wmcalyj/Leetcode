package com.leetcode.java;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *

 Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

 For example,
 Given the following matrix:

 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 You should return [1,2,3,6,9,8,7,4,5].

 *
 * @author mengchaowang
 *
 */
public class Q054 {

  public List<Integer> spiralOrder(int[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) {
      return new ArrayList<Integer>();
    }
    List<Integer> result = new ArrayList<Integer>();
    spiral(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1, result);
    return result;
  }

  public void spiral(int[][] matrix, int startRow, int endRow, int startCol, int endCol,
      List<Integer> result) {
    if (startCol >= endCol || startRow >= endRow) {
      if (startCol > endCol || startRow > endRow) {
        return;
      }
      if (startCol == endCol && startRow == endRow) {
        result.add(matrix[startRow][startCol]);
        return;
      }
      if (startRow < endRow) {
        for (int i = startRow; i <= endRow; i++) {
          result.add(matrix[i][startCol]);
        }
        return;
      }
      if (startCol < endCol) {
        for (int i = startCol; i <= endCol; i++) {
          result.add(matrix[startRow][i]);
        }
        return;
      }
      return;
    }
    for (int i = startCol; i < endCol; i++) {
      result.add(matrix[startRow][i]);
    }
    for (int i = startRow; i < endRow; i++) {
      result.add(matrix[i][endCol]);
    }
    for (int i = endCol; i > startCol; i--) {
      result.add(matrix[endRow][i]);
    }
    for (int i = endRow; i > startRow; i--) {
      result.add(matrix[i][startCol]);
    }
    spiral(matrix, startRow + 1, endRow - 1, startCol + 1, endCol - 1, result);
  }
}
