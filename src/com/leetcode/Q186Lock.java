package com.leetcode;

/**
 * 
 
Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

The input string does not contain leading or trailing spaces and the words are always separated by a single space.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Could you do it in-place without allocating extra space?  
  
 * 
 * @author mengchaowang
 *
 */
public class Q186Lock {
	public void reverseWords(char[] s) {
		if (s.length == 0) {
			return;
		}
		// Reverse the whole chars
		for (int i = 0; i < s.length / 2; i++) {
			char c = s[i];
			int other = s.length - 1 - i;
			s[i] = s[other];
			s[other] = c;
		}

		// Reverse each word again
		int start = 0;
		// No leading or trail spaces
		int i;
		for (i = 0; i < s.length; i++) {
			char c = s[i];
			if (Character.isSpaceChar(c)) {
				reverseWord(s, start, i - 1);
				start = i + 1;
			}
		}
		reverseWord(s, start, i - 1);
	}

	private void reverseWord(char[] s, int start, int end) {
		for (int i = start; i <= (start + end) / 2; i++) {
			char c = s[i];
			int tail = end - (i - start);
			s[i] = s[tail];
			s[tail] = c;
		}
	}

	public static void main(String[] args) {
		String[] strs = { "the sky is blue", "1", "hi!", "" };
		Q186Lock q = new Q186Lock();
		for (String s : strs) {
			char[] c = s.toCharArray();
			q.reverseWords(c);
			System.out.println(c);
		}
	}
}
