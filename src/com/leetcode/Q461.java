package com.leetcode;

/**
 * 
  
 The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different. 
 
 * 
 * 
 * @author mengchaowang
 *
 */
public class Q461 {
	public int hammingDistance(int x, int y) {
		String xs = Integer.toBinaryString(x);
		String ys = Integer.toBinaryString(y);
		System.out.println(xs + " " + ys);
		int count = 0;
		int i = xs.length() - 1;
		int j = ys.length() - 1;
		while (i >= 0 && j >= 0) {
			if (xs.charAt(i) != ys.charAt(j)) {
				count++;
			}
			i--;
			j--;
		}
		while (i >= 0) {
			if (xs.charAt(i) != '0') {
				count++;
			}
			i--;
		}
		while (j >= 0) {
			if (ys.charAt(j) != '0') {
				count++;
			}
			j--;
		}
		return count;
	}

	public static void main(String[] args) {
		Q461 q = new Q461();
		System.out.println(q.hammingDistance(0, 15));
	}
}
