package com.leetcode;

/**
 * 
 * 

This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “makes”, word2 = “coding”, return 1.
Given word1 = "makes", word2 = "makes", return 3.

 * 
 * @author mengchaowang
 *
 */
public class Q245Lock {
	public int shortestWordDistance(String[] words, String word1, String word2) {
		int lw = -1, rw = -1;
		int min = words.length;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1) || words[i].equals(word2)) {
				if (word1.equals(word2)) {
					if (lw != -1) {
						min = Math.abs(i - lw) < min ? Math.abs(i - lw) : min;
					}
					lw = i;
				} else {
					if (words[i].equals(word1)) {
						lw = i;
					} else if (words[i].equals(word2)) {
						rw = i;
					}
					// System.out.println("lw: " + lw + ", rw: " + rw);
					if (lw != -1 && rw != -1) {
						min = Math.abs(lw - rw) < min ? Math.abs(lw - rw) : min;
					}
				}
			}
		}
		return min;
	}

	public static void main(String[] args) {
		String[][] words = { { "practice", "makes", "perfect", "coding", "makes" } };
		String[] words1 = { "makes", "makes" };
		String[] words2 = { "coding", "makes" };

		Q245Lock q = new Q245Lock();
		for (String[] ws : words) {
			for (int i = 0; i < words1.length; i++) {
				System.out.println(q.shortestWordDistance(ws, words1[i], words2[i]));
			}
		}

	}
}
