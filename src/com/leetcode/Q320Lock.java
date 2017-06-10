package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
  
 Write a function to generate the generalized abbreviations of a word.

Example:
Given word = "word", return the following list (order does not matter):
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"] 
  
 * @author mengchaowang
 *
 */
public class Q320Lock {
	public List<String> generateAbbreviations(String word) {
		Set<String> result = new HashSet<String>();
		Set<String> calculated = new HashSet<String>();

		abbrHelper(word, result, "", calculated);
		return new ArrayList<String>(result);
	}

	public void abbrHelper(String subStr, Set<String> result, String tmp, Set<String> calculated) {
		if (calculated.contains(tmp + subStr)) {
			return;
		}
		if (subStr == null || subStr.length() == 0) {
			result.add(tmp);
			return;
		}
		int length = subStr.length();
		for (int replace = 1; replace <= length; replace++) {
			for (int i = 0; i <= length - replace; i++) {
				int repStart = i;
				int repEnd = i + replace;
				String prev = subStr.substring(0, repStart);
				String after = subStr.substring(repEnd);
				abbrHelper(after, result, tmp + prev + subStr.substring(repStart, repEnd), calculated);
				if (repEnd >= subStr.length()) {
					result.add(tmp + prev + replace);
				} else {
					abbrHelper(subStr.substring(repEnd + 1), result, tmp + prev + replace + subStr.charAt(repEnd),
							calculated);

				}
			}
		}
		calculated.add(tmp + subStr);
	}

	public static void main(String[] args) {
		Q320Lock q = new Q320Lock();
		int count = 0;
		for (String s : q.generateAbbreviations("word")) {
			System.out.println("[" + s + "]");
			count++;
		}
		System.out.println("count: " + count);
	}
}
