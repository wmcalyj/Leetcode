package com.leetcode;

/**
 * Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * @author mengchaowang
 *
 */
public class Q394Contest {
	public String decodeString(String s) {
		int index = 0;
		int currentInt = 0;
		StringBuilder result = new StringBuilder();

		while (index < s.length()) {
			// abc
			while (index < s.length() && Character.isAlphabetic(s.charAt(index))) {
				result.append(s.charAt(index));
				index++;
			}
			if (index == s.length()) {
				return result.toString();
			}
			while (Character.isDigit(s.charAt(index))) {
				// abc123[2[ac]]23[a]
				currentInt = currentInt * 10 + Integer.parseInt(String.valueOf(s.charAt(index)));
				index++;
			}
			int open = -1;
			int close = -1;
			if (s.charAt(index) == '[') {
				index++;
				open = index;
				close = findClose(s, index, 1);
				for (int i = 0; i < currentInt; i++) {
					if (open != -1 && close != -1) {
						result.append(decodeString(s.substring(open, close)));
					}
				}
			}

			if (close != -1) {
				index = close;
			}
			if (index == s.length()) {
				return result.toString();
			}
			index++;
			currentInt = 0;
		}
		return result.toString();

	}

	private int findClose(String s, int index, int i) {
		// {{{}}}
		int open = i;
		for (int c = index; c < s.length(); c++) {
			if (s.charAt(c) == '[') {
				open++;
			}
			if (s.charAt(c) == ']') {
				open--;
			}
			if (open == 0) {
				return c;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Q394Contest q = new Q394Contest();
		String[] s = { "3[a]2[bc]", "3[a2[c]]", "2[abc]3[cd]ef", "2[20[bc]31[xy]]xd4[rt]" };
		for (int i = 0; i < s.length; i++) {
			System.out.println(q.decodeString(s[i]));
		}
		String s2 = "2[20[bc]31[xy]]xd4[rt]";
		String a = "bcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcxyxyxyxyxyxyxyxyxyxyxyxyxyxyxyxyxyxyxyxyxyxyxyxyxyxyxyxyxyxyxybcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcxyxyxyxyxyxyxyxyxyxyxyxyxyxyxyxyxyxyxyxyxyxyxyxyxyxyxyxyxyxyxyxdrtrtrtrt";
		System.out.println(a.equals(q.decodeString(s2)));

	}
}
