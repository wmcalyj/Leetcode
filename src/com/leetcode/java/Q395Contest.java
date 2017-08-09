package com.leetcode.java;

import java.util.HashSet;
import java.util.Set;

/**
 * Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.

 Example 1:

 Input:
 s = "aaabb", k = 3

 Output:
 3

 The longest substring is "aaa", as 'a' is repeated 3 times.
 Example 2:

 Input:
 s = "ababbc", k = 2

 Output:
 5

 The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 * @author mengchaowang
 *
 */
public class Q395Contest {

  public int longestSubstring(String s, int k) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    // abab 2
    if (allValid(s, k)) {
      return s.length();
    }
    // ababc 2
    Set<Character> valid, invalid;
    valid = new HashSet<Character>();
    invalid = new HashSet<Character>();

    int[] sub = new int[26];
    for (int i = 0; i < s.length(); i++) {
      sub[s.charAt(i) - 'a'] += 1;
    }

    for (int i = 0; i < 26; i++) {
      if (sub[i] >= k) {
        valid.add((char) (i + 'a'));
      } else {
        invalid.add((char) (i + 'a'));
      }
    }

    int start = 0;
    int max = 0;
    int i;
    String substr = null;
    for (i = 0; i < s.length(); i++) {
      if (invalid.contains(s.charAt(i))) {
        if (i - start > max) {
          substr = s.substring(start, i);
          max = i - start;
        }
        start = i + 1;
      }
    }

    // abab 2
    if (valid.contains(s.charAt(i - 1))) {
      if (i - start > max) {
        substr = s.substring(start, i);
        max = i - start;
      }
    }

    // abcdabc 2
    if (substr != null) {
      return longestSubstring(substr, k);

    }
    return max;
  }

  private boolean allValid(String substr, int k) {
    int[] chars = new int[26];
    for (int i = 0; i < substr.length(); i++) {
      chars[substr.charAt(i) - 'a']++;
    }
    for (int i = 0; i < 26; i++) {
      if (chars[i] != 0 && chars[i] < k) {
        return false;
      }
    }
    return true;

  }

  public static void main(String[] args) {
    Q395Contest q = new Q395Contest();
    String[] s = {"aaabb", "ababbc", "ababacb", "aaabbb", "bbaaacbd"};
    int[] k = {3, 2, 3, 3, 3};
    for (int i = 0; i < s.length; i++) {
      System.out.println(q.longestSubstring(s[i], k[i]));
    }
  }
}
