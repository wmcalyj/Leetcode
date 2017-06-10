package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string, we can "shift" each of its letter to its successive letter,
 * for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
 * 
 * "abc" -> "bcd" -> ... -> "xyz" Given a list of strings which contains only
 * lowercase alphabets, group all strings that belong to the same shifting
 * sequence.
 * 
 * For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], A
 * solution is:
 * 
 * [ ["abc","bcd","xyz"], ["az","ba"], ["acef"], ["a","z"] ]
 * 
 * @author mengchaowang
 *
 */
public class Q249Lock {
	public List<List<String>> groupStrings(String[] strings) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String s : strings) {
			Integer count = map.get(s);
			if (count == null) {
				map.put(s, 1);
			} else {
				map.put(s, count + 1);
			}
		}
		List<List<String>> results = new ArrayList<List<String>>();
		for (String s : strings) {
			Integer count = map.get(s);

			if (count != null) {
				List<String> list = new ArrayList<String>();
				for (int i = 0; i < count; i++) {
					list.add(s);
				}
				map.remove(s);
				String shifted = shift(s);
				while (!s.equals(shifted)) {
					Integer c = map.get(shifted);
					if (c != null && c > 0) {
						for (int i = 0; i < c; i++) {
							list.add(shifted);
						}
						map.remove(shifted);
					}
					shifted = shift(shifted);
				}
				results.add(list);
			}
		}
		return results;

	}

	public String shift(String s) {
		char[] chs = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'z') {
				chs[i] = 'a';
			} else {
				chs[i] = (char) (c + 1);
			}
		}
		System.out.println(String.valueOf(chs));
		return String.valueOf(chs);
	}

	public static void main(String[] args) {
		String[] s = { "abc", "bcd", "acef", "xyz", "az", "ba", "a", "z" };
		Q249Lock q = new Q249Lock();
		q.groupStrings(s);
	}
}
