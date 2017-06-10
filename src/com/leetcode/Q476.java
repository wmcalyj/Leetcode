package com.leetcode;

/**
 * 
 * 
  
 Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

Note:
The given integer is guaranteed to fit within the range of a 32-bit signed integer.
You could assume no leading zero bit in the integer’s binary representation.
Example 1:
Input: 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
Example 2:
Input: 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0. 
  
 * 
 * @author mengchaowang
 *
 */
public class Q476 {
	public int findComplement(int num) {
		// String binary = Integer.toBinaryString(num);
		// System.out.println("num: " + num + "\nBinary: " + binary);
		int length = Integer.toBinaryString(num).length();
		int n = (int) (Math.pow(2, length) - 1);
		// System.out.println("n: " + Integer.toBinaryString(n));
		int result = num ^ n;
		// System.out.println("result: " + Integer.toBinaryString(result));
		return result;

		// return num ^ (int) (Math.pow(2, Integer.toBinaryString(num).length())
		// - 1);
	}

	public static void main(String[] args) {
		Q476 q = new Q476();
		int[] n = { 5, 1, 0, 2, 20161211 };
		for (int i : n) {
			System.out.println(q.findComplement(i));
		}
	}
}
