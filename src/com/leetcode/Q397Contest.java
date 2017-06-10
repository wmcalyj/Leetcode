package com.leetcode;

/**
 * 
  
 Given a positive integer n and you can do operations as follow:

If n is even, replace n with n/2.
If n is odd, you can replace n with either n + 1 or n - 1.
What is the minimum number of replacements needed for n to become 1?

Example 1:

Input:
8

Output:
3

Explanation:
8 -> 4 -> 2 -> 1
Example 2:

Input:
7

Output:
4

Explanation:
7 -> 8 -> 4 -> 2 -> 1
or
7 -> 6 -> 3 -> 2 -> 1
  
 * @author mengchaowang
 *
 */
public class Q397Contest {
	public int integerReplacement(int n) {
		if (n <= 1) {
			return 0;
		}

		if (n % 2 == 0) {
			n = n / 2;
			return integerReplacement(n) + 1;
		} else {
			int plus = n < Integer.MAX_VALUE ? integerReplacement(n + 1) : -1;
			int minus = n > Integer.MIN_VALUE ? integerReplacement(n - 1) : -1;
			System.out.println("Plus: " + plus + ", Minus: " + minus);
			if (plus == -1) {
				return minus;
			}
			if (minus == -1) {
				return plus;
			}
			return minus <= plus ? minus + 1 : plus + 1;
		}
	}

	public static void main(String[] args) {
		Q397Contest q = new Q397Contest();
		System.out.println(q.integerReplacement(8));
		System.out.println(q.integerReplacement(7));
		System.out.println(q.integerReplacement(2147483647));
		System.out.println(q.integerReplacement(22222222));

	}
}
