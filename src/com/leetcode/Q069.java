package com.leetcode;

/**
 * 
  
 Implement int sqrt(int x).

Compute and return the square root of x. 
  
 * @author mengchaowang
 *
 */
public class Q069 {
	public int mySqrt(int x) {
		if (x == 0)
			return 0;
		int start = 1;
		int end = x;
		while (true) {
			int middle = (start + end) / 2;

			int next = middle + 1;
			if (x / middle >= middle && x / next < next) {
				return (int) middle;
			}
			if (x / middle < middle) {
				end = middle - 1;
			} else {
				start = middle + 1;
			}
		}
	}

	public int binarySearch(int x, int start, int end) {
		int middle = (start + end) / 2;
		int next = middle + 1;
		int square = middle * middle;
		if (square <= x && next * next > x) {
			return middle;
		}
		if (square > x) {
			return binarySearch(x, start, middle - 1);
		} else {
			return binarySearch(x, middle + 1, end);
		}
	}

	public static void main(String[] args) {
		Q069 q = new Q069();
		System.out.println(q.mySqrt(Integer.MAX_VALUE));
		System.out.println(q.mySqrt(0));
		for (int i = 0; i <= 10; i++) {
			System.out.println(q.mySqrt(i));
		}

	}
}
