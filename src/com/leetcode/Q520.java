package com.leetcode;

/**
 * 
  
 Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital if it has more than one letter, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way. 
  
  Example 1:
Input: "USA"
Output: True
Example 2:
Input: "FlaG"
Output: False


 * 
 * @author mengchaowang
 *
 */
public class Q520 {
	public boolean detectCapitalUse(String word) {
		if (word == null || word.length() == 0) {
			return true;
		}
		if (Character.isUpperCase(word.charAt(0))) {
			return validStartWithUpperCase(word);
		} else {
			return validStartWithLowerCase(word);
		}

	}

	private boolean validStartWithLowerCase(String word) {
		for (int i = 1; i < word.length(); i++) {
			if (!Character.isLowerCase(word.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	private boolean validStartWithUpperCase(String word) {
		int lower = 0, upper = 0;
		for (int i = 1; i < word.length(); i++) {
			if (Character.isUpperCase(word.charAt(i))) {
				upper++;
			} else {
				lower++;
			}
			if (upper > 0 && lower > 0) {
				return false;
			}
		}
		return true;
	}
}
