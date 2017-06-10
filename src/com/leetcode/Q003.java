package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 
  
 Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring. 
 
 * 
 * @author mengchaowang
 *
 */
public class Q003 {
	public int lengthOfLongestSubstring(String s) {
		if (s == null) {
			return 0;
		}
		int max = 0;
		Set<Character> visited = new HashSet<Character>();
		int count1 = 0, count2 = 0;
		while (count1 < s.length()) {
			while (count2 < s.length()) {
				Character c = s.charAt(count2);
				if (!visited.contains(c)) {
					visited.add(c);
					count2++;
				} else {
					break;
				}
			}
			visited = new HashSet<Character>();
			if (count2 - count1 > max) {
				max = count2 - count1;
			}
			count1++;
			count2 = count1;
		}
		return max;
	}

	public static void main(String[] args) {
		Q003 q = new Q003();
		System.out.println(q.lengthOfLongestSubstring("abcdefg"));
		System.out.println(q.lengthOfLongestSubstring(""));
		System.out.println(q.lengthOfLongestSubstring("abcabc"));
		System.out.println(q.lengthOfLongestSubstring("abcdea"));
		System.out.println(q.lengthOfLongestSubstring("aaaaa"));
	}
}
