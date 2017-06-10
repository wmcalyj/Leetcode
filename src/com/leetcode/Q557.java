package com.leetcode;

/**
 * 
 * 
  
 Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

  
 * 
 * @author mengchaowang
 *
 */
public class Q557 {
	public String reverseWords(String s) {
		if (s == null) {
			return null;
		}
		String[] words = s.split(" ");
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for (i = 0; i < words.length - 1; i++) {
			sb.append(reverse(words[i])).append(" ");
		}
		if (i < words.length)
			sb.append(reverse(words[i]));
		return sb.toString();
	}

	public String reverse(String word) {
		StringBuilder sb = new StringBuilder();
		for (int i = word.length() - 1; i >= 0; i--) {
			sb.append(word.charAt(i));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Q557 q = new Q557();
		String[] cases = { "Let's take LeetCode contest", " ", "", "lal", "lala", "hello world" };
		for (String sentence : cases) {
			System.out.println(q.reverseWords(sentence));
		}

	}
}
