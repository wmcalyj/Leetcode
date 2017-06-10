package com.leetcode;

/**
 * 
  
 Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.

IMPORTANT:
You must not use any method provided by the library which converts/formats the number to hex directly. Such solution will result in disqualification of all your submissions to this problem. Users may report such solutions after the contest ends and we reserve the right of final decision and interpretation in the case of reported solutions.

Note:

All letters in hexadecimal (a-f) must be in lowercase.
The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
The given number is guaranteed to fit within the range of a 32-bit signed integer.
You must not use any method provided by the library which converts/formats the number to hex directly.
Example 1:

Input:
26

Output:
"1a"
Example 2:

Input:
-1

Output:
"ffffffff" 
  
 * 
 * @author mengchaowang
 *
 */
public class Q405Contest {
	public String toHex(int num) {
		if (num == 0) {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		while (num != 0) {
			sb.append(Math.abs(num % 2));
			num = num >>> 1;
		}
		String binary = sb.toString();

		int start = 0;
		int end = start + 4 >= binary.length() ? binary.length() : start + 4;
		StringBuilder hex = new StringBuilder();
		while (start < binary.length()) {
			String tmp = binary.substring(start, end);
			hex.insert(0, processOneBit(tmp));
			start = end;
			end = start + 4 >= binary.length() ? binary.length() : start + 4;
		}
		return hex.toString();
	}

	private char processOneBit(String tmp) {
		int value = 0;
		for (int i = 0; i < tmp.length(); i++) {
			value += (int) (Math.pow(2, i) * (tmp.charAt(i) - '0'));
		}
		if (value < 10) {
			return (char) ('0' + value);
		} else {
			return (char) ('a' + (value - 10));
		}

	}

	public static void main(String[] args) {
		Q405Contest q = new Q405Contest();
		for (int i = -10; i <= 10; i++) {
			assert (Integer.toHexString(i).equals(q.toHex(i)));
		}
		System.out.println(q.toHex(Integer.MAX_VALUE));
		System.out.println(q.toHex(Integer.MIN_VALUE));
		System.out.println(Integer.toHexString(Integer.MAX_VALUE));
		System.out.println(Integer.toHexString(Integer.MIN_VALUE));
		System.out.println(Integer.toHexString(0));

		assert (Integer.toHexString(Integer.MAX_VALUE).equals(q.toHex(Integer.MAX_VALUE)));
		assert (Integer.toHexString(Integer.MIN_VALUE).equals(q.toHex(Integer.MIN_VALUE)));
		System.out.println("all pass");

	}
}
