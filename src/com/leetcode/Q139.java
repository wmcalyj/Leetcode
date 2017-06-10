package com.leetcode;

import java.util.Set;

/**
 * 
  
 Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code". 
 
 * 
 * @author mengchaowang
 *
 */
public class Q139 {
	public boolean wordBreak(String s, Set<String> wordDict) {
		System.out.println(s);
		if (s == null || s.length() == 0) {
			return false;
		}
		if (wordDict.contains(s)) {
			return true;
		}
		for (int i = 0; i < s.length(); i++) {
			if (!wordDict.contains(s.substring(0, i))) {
				continue;
			} else {
				if (wordBreak(s.substring(i, s.length()), wordDict)) {
					return true;
				}
			}
		}
		return false;
	}
}
