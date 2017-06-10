package com.leetcode;

/**
 * 
  
  Given the coordinates of four points in 2D space, return whether the four points could construct a square.

The coordinate (x,y) of a point is represented by an integer array with two integers.

Example:
Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
Output: True
Note:

All the input integers are in the range [-10000, 10000].
A valid square has four equal sides with positive length and four equal angles (90-degree angles).
Input points have no order.
 
  
 * @author mengchaowang
 *
 */
public class Q593 {
	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		return check(p1, p2, p3, p4) && check(p2, p1, p3, p4) && check(p3, p1, p2, p4) && check(p4, p1, p2, p3);
	}

	public boolean check(int[] p1, int[] p2, int[] p3, int[] p4) {
		double l12 = dist(p1, p2);
		double l13 = dist(p1, p3);
		double l14 = dist(p1, p4);
		if (l12 == 0 || l13 == 0 || l14 == 0) {
			return false;
		}
		if (l12 == l13 && cosIsZero(p1, p2, p3)) {
			return true;
		}
		if (l12 == l14 && cosIsZero(p1, p2, p4)) {
			return true;
		}
		if (l13 == l14 && cosIsZero(p1, p3, p4)) {
			return true;
		}
		return false;
	}

	private boolean cosIsZero(int[] p1, int[] p2, int[] p3) {
		int[] u = { p2[0] - p1[0], p2[1] - p1[1] };
		int[] v = { p3[0] - p1[0], p3[1] - p1[1] };
		double uv = u[0] * v[0] + u[1] * v[1];
		return uv == 0;
	}

	public double dist(int[] p1, int[] p2) {
		return Math.sqrt(Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
	}

	public static void main(String[] args) {
		Q593 q = new Q593();
		int[][][] tests = { { { 0, 0 }, { 1, 1 }, { 1, 0 }, { 0, 1 } }, { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } },
				{ { 3127, 253 }, { 915, 1225 }, { 1535, -367 }, { 2507, 1845 } } };

		System.out.println(q.validSquare(tests[2][0], tests[2][1], tests[2][2], tests[2][3]));

		// for (int[][] test : tests) {
		// System.out.println(q.validSquare(test[0], test[1], test[2],
		// test[3]));
		// }
	}
}
