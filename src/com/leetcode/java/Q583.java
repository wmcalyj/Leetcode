package com.leetcode.java;

/**
 *

 Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.

 Example 1:
 Input: "sea", "eat"
 Output: 2
 Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 Note:
 The length of given words won't exceed 500.
 Characters in given words can only be lower-case letters.


 * @author mengchaowang
 *
 */
public class Q583 {

  public int minDistance(String word1, String word2) {
    int longest = findLongestCommonSubSequence(word1, word2);
    return word1.length() - longest + word2.length() - longest;
  }

  private int findLongestCommonSubSequence(String word1, String word2) {
    int[][] matrix = new int[word1.length() + 1][word2.length() + 1];
    int re = 0;
    for (int i = 1; i <= word1.length(); i++) {
      for (int j = 1; j <= word2.length(); j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          matrix[i][j] = matrix[i - 1][j - 1] + 1;
        } else {
          matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
        }
        re = Math.max(matrix[i][j], re);
      }
    }
    return re;
  }

  public static void main(String[] args) {
    Q583 q = new Q583();
    String[] word1 = {"eat", "abc", "def", "aaaaaaaaaa", "aaaaaaaaaa", "sea"};
    String[] word2 = {"sea", "def", "def", "a", "aaaaaaaaa", "ate"};
    System.out.println(q.minDistance("intention", "execution"));
    // for (int i = 0; i < word1.length; i++) {
    // System.out.println(q.minDistance(word1[i], word2[i]));
    // }
  }
}
