package com.leetcode;

/**
 * 
  
 Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.

Example1:

a = 2
b = [3]

Result: 8
Example2:

a = 2
b = [1,0]

Result: 1024
  
 * 
 * @author mengchaowang
 *
 */
public class Q372 {
	public int superPow(int a, int[] b) {
		int count = 0;
		double re = 1;
		for (int i = b.length - 1; i >= 0; i++) {
			double base = Math.pow(10, count++);
			re = Math.pow(a, b[i] * base);
		}
		return (int) re;
	}
}
