package com.leetcode;

/**
 * 
  
  Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.

A string such as "word" contains only the following valid abbreviations:

["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
Notice that only the above abbreviations are valid abbreviations of the string "word". Any other string is not a valid abbreviation of "word".

Note:
Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.

Example 1:
Given s = "internationalization", abbr = "i12iz4n":

Return true.
Example 2:
Given s = "apple", abbr = "a2e":

Return false.
  
 * 
 * @author mengchaowang
 *
 */
public class Q408Contest {
	public boolean validWordAbbreviation(String word, String abbr) {
		int pos = 0;
		int i = 0;
		for (; i < abbr.length(); i++) {
			if (pos >= word.length()) {
				return false;
			}
			char cur = abbr.charAt(i);
			if (!Character.isDigit(cur)) {
				if (word.charAt(pos) != cur) {
					return false;
				} else {
					pos++;
				}
			} else {
				int count = Character.getNumericValue(cur);
				if (count == 0) {
					return false;
				}
				int j = i + 1;
				while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
					count = count * 10 + Character.getNumericValue(abbr.charAt(j));
					j++;
				}
				i = j - 1;
				pos += count;
			}
		}
		return i == abbr.length() && pos == word.length();
	}

	public static void main(String[] args) {
		Q408Contest q = new Q408Contest();
		String[] words = { "internationalization", "apple", "internationalization", "apple", "internationalization",
				"a" };
		String[] abbrs = { "i12iz4n", "a2e", "i18n", "a18e", "i5a11o1", "01" };
		for (int i = 0; i < words.length; i++) {
			System.out.println(q.validWordAbbreviation(words[i], abbrs[i]));
		}
	}
}
