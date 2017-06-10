package com.leetcode;

/**
 * 
  
 Given an integer n, find the closest integer (not including itself), which is a palindrome.

The 'closest' is defined as absolute difference minimized between two integers.

Example 1:
Input: "123"
Output: "121"
Note:
The input n is a positive integer represented by string, whose length will not exceed 18.
If there is a tie, return the smaller one as answer. 
  
 * @author mengchaowang
 *
 */
public class Q564 {
	public String nearestPalindromic(String n) {
		if (n.length() == 1) {
			return "" + (Integer.valueOf(n) - 1);
		}
		long same = same(n);
		long large = large(n);
		long small = small(n);
		long original = Long.valueOf(n);
		System.out.println("same - " + same + ", large - " + large + ", small - " + small + ", original - " + original);

		long deltaSame = same - original;
		long deltaLarge = large - original;
		long deltaSmall = small - original;

		if (deltaSame == 0) {
			deltaSame = Long.MAX_VALUE;
		}
		if (deltaLarge == 0) {
			deltaLarge = Long.MAX_VALUE;
		}
		if (deltaSmall == 0) {
			deltaSmall = Long.MAX_VALUE;
		}

		if (Math.abs(deltaSame) < Math.abs(deltaLarge) && Math.abs(deltaSame) < Math.abs(deltaSmall)) {
			return "" + same;
		}
		if (Math.abs(deltaLarge) < Math.abs(deltaSame) && Math.abs(deltaLarge) < Math.abs(deltaSmall)) {
			return "" + large;
		}
		if (Math.abs(deltaSmall) < Math.abs(deltaLarge) && Math.abs(deltaSmall) < Math.abs(deltaSame)) {
			return "" + small;
		}

		if (Math.abs(deltaSmall) == Math.abs(deltaLarge)) {
			if (deltaSmall < 0) {
				return "" + small;
			} else {
				return "" + large;
			}
		}
		if (Math.abs(deltaSame) == Math.abs(deltaLarge)) {
			if (deltaSame < 0) {
				return "" + same;
			} else {
				return "" + large;
			}
		}
		if (Math.abs(deltaSmall) == Math.abs(deltaSame)) {
			if (deltaSmall < 0) {
				return "" + small;
			} else {
				return "" + same;
			}
		}

		String re = "";
		return re;

	}

	private long small(String n) {
		int length = n.length();
		boolean odd = n.length() % 2 == 1;
		StringBuilder sb = new StringBuilder();
		String left = "" + (Long.valueOf(n.substring(0, length / 2 + length % 2)) - 1);
		if (left.equals("0") || left.length() < length / 2 + length % 2) {
			StringBuilder re = new StringBuilder();
			for (int i = 0; i < n.length() - 1; i++) {
				re.append("9");
			}
			return Long.valueOf(re.toString());
		}

		StringBuilder mirror = new StringBuilder(left);
		sb.append(left);
		sb.append(odd ? mirror.reverse().substring(1) : mirror.reverse());
		return Long.valueOf(sb.toString());
	}

	private long large(String n) {
		int length = n.length();
		boolean odd = n.length() % 2 == 1;
		StringBuilder sb = new StringBuilder();
		String left = "" + (Long.valueOf(n.substring(0, length / 2 + length % 2)) + 1);
		if (left.length() > length / 2 + length % 2) {
			odd = (n.length() + 1) % 2 == 1;
			if (!odd) {
				left = left.substring(0, left.length() - 1);
			}
		}
		StringBuilder mirror = new StringBuilder(left);
		sb.append(left);
		sb.append(odd ? mirror.reverse().substring(1) : mirror.reverse());
		return Long.valueOf(sb.toString());
	}

	private long same(String n) {
		int length = n.length();
		StringBuilder sb = new StringBuilder();
		String left = n.substring(0, length / 2);
		StringBuilder mirror = new StringBuilder();
		sb.append(left);
		if (length % 2 == 1) {
			sb.append(n.charAt(length / 2));
		}
		return Long.valueOf(sb.append(mirror.append(left).reverse()).toString());

	}

	public static void main(String[] args) {
		Q564 q = new Q564();
		String[] cases = { "1", "11", "999", "99" };
		for (String c : cases) {
			System.out.println(q.nearestPalindromic(c));
		}
	}
}
