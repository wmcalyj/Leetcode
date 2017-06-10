package com.leetcode;

/**
 * Given a string s and a string t, check if s is subsequence of t.

You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
s = "abc", t = "ahbgdc"

Return true.

Example 2:
s = "axc", t = "ahbgdc"

Return false.
 * @author mengchaowang
 *
 */
public class Q392Contest {
	public boolean isSubsequence(String s, String t) {
		char[] schar = s.toCharArray();
		if (s.length() == 0) {
			return true;
		}
		int count = 0;
		for (int i = 0; i < t.length(); i++) {
			if (t.charAt(i) == schar[count]) {
				count++;
			}
			if (count == s.length()) {
				return true;
			}
		}
		if (count != s.length()) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Q392Contest q = new Q392Contest();
		System.out.println(q.isSubsequence("abc", "adbecf"));
		System.out.println(q.isSubsequence("abc", "adecfb"));
	}
}
