package com.leetcode.java;

/**
 * Created by mengchaowang on 7/3/17.
 *

 Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

 Example 1:
 Input:

 "bbbab"
 Output:
 4
 One possible longest palindromic subsequence is "bbbb".
 Example 2:
 Input:

 "cbbd"
 Output:
 2
 One possible longest palindromic subsequence is "bb".

 *
 */
public class Q516 {

  public int longestPalindromeSubseq(String s) {
    int re = 0;
    for (int i = 0, j = s.length() - 1; i < s.length(); i++) {
      int left = longestFromLeft(s, i, j);
      int right = longestFromRight(s, i, j);
      re = Math.max(re, Math.max(left, right));
    }
    return re;
  }

  private int longestFromRight(String s, int i, int j) {
    int count = 0;
    while (i <= j) {
      if (i == j) {
        count++;
        break;
      }
      if (s.charAt(i) == s.charAt(j)) {
        i++;
        j--;
        count += 2;
      } else {
        i++;
      }
    }
    return count;
  }

  private int longestFromLeft(String s, int i, int j) {
    int count = 0;
    while (i <= j) {
      if (i == j) {
        count++;
        break;
      }
      if (s.charAt(i) == s.charAt(j)) {
        i++;
        j--;
        count += 2;
      } else {
        j--;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    String[] tests = {"bbbab", "cbbd",
        "euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtm"
            + "zpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfela"
            + "hqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjj"
            + "geztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmsh"
            + "dpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmql"
            + "gkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew"};
    Q516 q = new Q516();
    for (String test : tests) {
      System.out.println(q.longestPalindromeSubseq(test));
    }
  }


}
