package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
  
 Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0 
  
 * 
 * 
 * @author mengchaowang
 *
 */
public class Q318 {
	public int maxProduct(String[] words) {
		List<Set<Character>> list = new ArrayList<Set<Character>>();
		for (int i = 0; i < words.length; i++) {
			Set<Character> chars = new HashSet<Character>();
			for (int j = 0; j < words[i].length(); j++) {
				chars.add(words[i].charAt(j));
			}
			list.add(chars);
		}


	}
}
