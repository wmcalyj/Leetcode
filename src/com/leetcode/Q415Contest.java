package com.leetcode;

/**
 * 
  
 Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.


 * @author mengchaowang
 *
 */
public class Q415Contest {
	public String addStrings(String num1, String num2) {
		int i = num1.length() - 1;
		int j = num2.length() - 1;
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		while (i >= 0 && j >= 0) {
			int n1 = Character.getNumericValue(num1.charAt(i));
			int n2 = Character.getNumericValue(num2.charAt(j));
			sb.insert(0, (n1 + n2 + carry) % 10);
			carry = (n1 + n2 + carry) / 10;
			i--;
			j--;
		}
		while (i >= 0) {
			int n1 = Character.getNumericValue(num1.charAt(i));
			sb.insert(0, (n1 + carry) % 10);
			carry = (n1 + carry) / 10;
			i--;
		}
		while (j >= 0) {
			int n2 = Character.getNumericValue(num2.charAt(j));
			sb.insert(0, (n2 + carry) % 10);
			carry = (n2 + carry) / 10;
			j--;
		}
		if (carry > 0) {
			sb.insert(0, carry);
		}

		return sb.toString();

	}

	public static void main(String[] args) {
		Q415Contest q = new Q415Contest();
		String[] s1 = { "1", "2", "99", "99999999999999999999", "0", "0" };
		String[] s2 = { "99999999999999999999", "1", "2", "99", "0", "1" };
		for (int i = 0; i < s1.length; i++) {
			System.out.println(q.addStrings(s1[i], s2[i]));
		}
	}
}
