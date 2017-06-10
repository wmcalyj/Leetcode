package com.leetcode;

/**
 * 
 
 Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 
  
  
 * 
 */
public class Q400Contest {

	public int findNthDigit(int n) {
		int length = 1;
		int level = 0;
		int start = 1;
		while (n - Math.pow(10, level) * length * 9 > 0) {
			n = (int) (n - Math.pow(10, level) * length * 9);
			level++;
			length++;
			start = (int) Math.pow(10, level);

		}
		String number = Integer.toString(start + ((n - 1) / length));
		char digit = number.charAt((n - 1) % length);
		return Character.getNumericValue(digit);
	}

	public static void main(String[] args) {
		Q400Contest q = new Q400Contest();

		System.out.println(q.findNthDigit(100));
	}
}
