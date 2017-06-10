package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 
Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.


American keyboard


Example 1:
Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"] 
  
 * 
 * @author mengchaowang
 *
 */
public class Q500 {
	public String[] findWords(String[] words) {
		Set<String> keyboard1 = new HashSet<String>(Arrays.asList("q", "w", "e", "r", "t", "y", "u", "i", "o", "p"));
		Set<String> keyboard2 = new HashSet<>(Arrays.asList("a", "s", "d", "f", "g", "h", "j", "k", "l"));
		Set<String> keyboard3 = new HashSet<>(Arrays.asList("z", "x", "c", "v", "b", "n", "m"));
		List<String> re = new ArrayList<String>();
		for (String word : words) {
			if (valid(word, keyboard1, keyboard2, keyboard3)) {
				re.add(word);
			}
		}
		String[] res = new String[re.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = re.get(i);
		}
		return res;
	}

	private boolean valid(String word, Set<String>... keyboards) {
		String first = word.substring(0, 1).toLowerCase();
		int row = findRowForFirstChar(first, keyboards);
		if (row == -1) {
			return false;
		} else {
			for (int i = 1; i < word.length(); i++) {
				String c = String.valueOf(word.charAt(i)).toLowerCase();
				if (!keyboards[row].contains(c)) {
					return false;
				}
			}
		}
		return true;
	}

	private int findRowForFirstChar(String first, Set<String>[] keyboards) {
		for (int i = 0; i < keyboards.length; i++) {
			if (keyboards[i].contains(first)) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Q500 q = new Q500();
		String[][] cases = { {}, { "Hello", "Alaska", "Dad", "Peace" } };
		for (String[] words : cases) {
			printResult(q.findWords(words));
		}
	}

	private static void printResult(String[] findWords) {
		StringBuilder sb = new StringBuilder("[");
		int i = 0;
		for (; i < findWords.length - 1; i++) {
			sb.append(findWords[i]).append(", ");
		}
		if (i < findWords.length) {
			sb.append(findWords[i]);
		}
		sb.append("]");
		System.out.println(sb.toString());
	}
}
