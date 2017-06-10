package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
  
 This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?

Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1. 
 
 * 
 * @author mengchaowang
 *
 */
public class Q244Lock {
	Map<String, List<Integer>> cache;
	Map<TwoWords, Integer> minMap;

	public class TwoWords {
		String word1;
		String word2;

		public TwoWords(String word1, String word2) {
			this.word1 = word1;
			this.word2 = word2;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null || !(obj instanceof TwoWords)) {
				return false;
			}
			if (this.word1.equals(((TwoWords) obj).word1) && this.word2.equals(((TwoWords) obj).word2)) {
				return true;
			}
			if (this.word1.equals(((TwoWords) obj).word2) && this.word2.equals(((TwoWords) obj).word1)) {
				return true;
			}
			return false;
		}
	}

	public Q244Lock(String[] words) {
		cache = new HashMap<String, List<Integer>>();
		for (int i = 0; i < words.length; i++) {
			List<Integer> index = cache.containsKey(words[i]) ? cache.get((words[i])) : new ArrayList<Integer>();
			index.add(i);
			cache.put(words[i], index);
		}
		minMap = new HashMap<TwoWords, Integer>();
	}

	public int shortest(String word1, String word2) {
		// Already cached
		TwoWords s12 = new TwoWords(word1, word2);
		if (minMap.containsKey(s12)) {
			return minMap.get(s12);
		}

		int min = Integer.MAX_VALUE;
		List<Integer> pos1 = cache.get(word1);
		List<Integer> pos2 = cache.get(word2);

		for (int i = 0; i < pos1.size(); i++) {
			for (int j = 0; j < pos2.size(); j++) {
				int abs = Math.abs(pos1.get(i) - pos2.get(j));
				min = abs < min ? abs : min;
			}
		}
		minMap.put(s12, min);
		return min;
	}
}
