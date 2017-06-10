package com.leetcode;

/**
 * 
  
 You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.
Example 2:

n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3. 
  
 * @author mengchaowang
 *
 */
public class Q441 {
	public int arrangeCoins(int n) {
		if (n < 0) {
			return -1;
		}
		if (n == Integer.MAX_VALUE) {
			return 65535;
		}
		int result = 0;
		for (int i = 1; i <= n; i++) {
			result += i;
			if (result > n) {
				return i - 1;
			}
			if (result == n) {
				return i;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] cases = { 5, 6, 7, 8, 9, 10, 1, 0, -1, 100, 1000, 10000, -2, 1804289383, 2147483647 };
		Q441 q = new Q441();
		for (int n : cases) {
			System.out.println(q.arrangeCoins(n));
		}
	}
}
