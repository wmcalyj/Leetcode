package com.leetcode;

/**
 * 
 * 
  
 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true. 
  
 * 
 * @author mengchaowang
 *
 */
public class Q074 {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || target < matrix[0][0]) {
			return false;
		}
		int row = findRow(matrix, target, 0, matrix.length - 1);

		if (row == -1) {
			return false;
		}

		if (!findColumn(matrix[row], target, 0, matrix[0].length - 1)) {
			return false;
		}

		return true;
	}

	private boolean findColumn(int[] matrix, int target, int head, int tail) {
		if (head > tail) {
			return false;
		}
		if (head == tail) {
			return target == matrix[head];
		}
		int mid = (head + tail) / 2;
		if (target == matrix[mid]) {
			return true;
		} else if (target > matrix[mid]) {
			return findColumn(matrix, target, mid + 1, tail);
		} else {
			return findColumn(matrix, target, head, mid);
		}
	}

	private int findRow(int[][] matrix, int target, int head, int tail) {
		if (head == tail) {
			if (head == matrix.length - 1) {
				return head;
			}
			if (target >= matrix[head][0] && target < matrix[head + 1][0]) {
				return head;
			} else {
				return -1;
			}
		}
		int mid = (head + tail) / 2;
		if (target == matrix[mid][matrix[mid].length - 1]) {
			return mid;
		} else if (target > matrix[mid][matrix[mid].length - 1]) {
			return findRow(matrix, target, mid + 1, tail);
		} else {
			return findRow(matrix, target, head, mid);
		}
	}

	public static void main(String[] args) {
		Q074 q = new Q074();
		int[][][] cases = { { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } } };
		// int[] targets = { 3, 4, 5, 6, 7, 8, 9, 10, };
		// for (int i = 0; i < cases.length; i++) {
		// System.out.println(q.searchMatrix(cases[i], targets[i]));
		// }
		System.out.println("10: " + q.searchMatrix(cases[0], 11));

		for (int i = 0; i <= 60; i++) {
			System.out.println(i + ": " + q.searchMatrix(cases[0], i));
		}

	}

}
