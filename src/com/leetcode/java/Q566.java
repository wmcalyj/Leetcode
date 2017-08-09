package com.leetcode.java;

/**
 *

 In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.

 You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.

 The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.

 If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

 Example 1:
 Input:
 nums =
 [[1,2],
 [3,4]]
 r = 1, c = 4
 Output:
 [[1,2,3,4]]
 Explanation:
 The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is an 1 * 4 matrix, fill it row by row by using the previous list.
 Example 2:
 Input:
 nums =
 [[1,2],
 [3,4]]
 r = 2, c = 4
 Output:
 [[1,2],
 [3,4]]
 Explanation:
 There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.

 *
 * @author mengchaowang
 *
 */
public class Q566 {

  public int[][] matrixReshape(int[][] nums, int r, int c) {
    if (nums == null || nums.length == 0 || nums[0].length == 0
        || r * c != nums.length * nums[0].length) {
      return nums;
    }
    int[][] re = new int[r][c];
    int i = 0, j = 0;
    int oi = 0, oj = 0;
    int count = 0;
    while (count < r * c) {
      if (j == c) {
        j = 0;
        i++;
      }
      if (oj == nums[oi].length) {
        oj = 0;
        oi++;
      }
      re[i][j] = nums[oi][oj];
      count++;
      j++;
      oj++;
    }
    return re;

  }
}