package com.leetcode.java;

import java.util.HashSet;
import java.util.Set;

/**
 *

 Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz", so s will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".

 Now we have another string p. Your job is to find out how many unique non-empty substrings of p are present in s. In particular, your input is the string p and you need to output the number of different non-empty substrings of p in the string s.

 Note: p consists of only lowercase English letters.

 Example 1:
 Input: "a"
 Output: 1

 Explanation: Only the substring "a" of string "a" is in the string s.
 Example 2:
 Input: "cac"
 Output: 2
 Explanation: There are two substrings "a", "c" of string "cac" in the string s.
 Example 3:
 Input: "zab"
 Output: 6
 Explanation: There are six substrings "z", "a", "b", "za", "ab", "zab" of string "zab" in the string s.

 *
 * @author mengchaowang
 *
 */
public class Q467Contest {

  public int findSubstringInWraproundString(String p) {
    Set<String> baseUnique = new HashSet<String>();
    int total = p.length();
    for (int i = 0; i < total; i++) {
      baseUnique.add(String.valueOf(p.charAt(i)));
    }
    int count = 2;
    while (count <= total) {
      for (int i = 0; i <= total - count; i++) {
        StringBuilder sb = new StringBuilder();
        boolean valid = true;
        for (int j = i; j < i + count; j++) {
          if (j > i) {
            if (p.charAt(j) == 'a') {
              if (p.charAt(j - 1) != 'z') {
                valid = false;
                break;
              }
            } else {
              if (p.charAt(j) - p.charAt(j - 1) != 1) {
                valid = false;
                break;
              }
            }
          }
          sb.append(p.charAt(j));
        }
        if (valid) {
          baseUnique.add(sb.toString());
        }

      }
      count++;
    }
    return baseUnique.size();
  }

  public int findSubstringInWraproundString2(String p) {
    if (p == null || p.isEmpty()) {
      return 0;
    }
    Set<String> baseUnique = new HashSet<String>();
    int total = p.length();
    for (int i = 0; i < total; i++) {
      baseUnique.add(String.valueOf(p.charAt(i)));
    }
    int result = baseUnique.size();
    int max = 1;
    int currentIdx = 1;
    int start = 0;
    while (currentIdx < total) {
      if (p.charAt(currentIdx) == 'a') {
        if (p.charAt(currentIdx - 1) != 'z') {
          int diff = currentIdx - start;
          String subStr = p.substring(start, currentIdx);
          if (!baseUnique.contains(subStr)) {
            if (diff >= 26) {
              result = result + (diff - 26) * 26 + 27 * 26 / 2 - 26;
            } else {
              result = result + (diff + 1) * diff / 2 - diff;
            }
            baseUnique.add(subStr);
          }
          start = currentIdx;
        }
      } else {
        if (p.charAt(currentIdx) - p.charAt(currentIdx - 1) != 1) {
          int diff = currentIdx - start;
          String subStr = p.substring(start, currentIdx);
          if (!baseUnique.contains(subStr)) {
            if (diff >= 26) {
              result = result + (diff - 26) * 26 + 27 * 26 / 2 - 26;
            } else {
              result = result + (diff + 1) * diff / 2 - diff;
            }
            baseUnique.add(subStr);
          }
          start = currentIdx;
        }
      }
      currentIdx++;
    }
    int diff = currentIdx - start > max ? currentIdx - start : max;
    String subStr = p.substring(start, currentIdx);
    if (!baseUnique.contains(subStr)) {
      if (diff >= 26) {
        result = result + (diff - 26) * 26 + 27 * 26 / 2 - 26;
      } else {
        result = result + (diff + 1) * diff / 2 - diff;
      }
      baseUnique.add(subStr);
    }
    return result;
  }

  public int findSubstringInWraproundString3(String p) {
    if (p == null || p.isEmpty()) {
      return 0;
    }
    Set<String> allUnique = new HashSet<String>();
    Set<String> baseUnique = new HashSet<String>();

    int total = p.length();

    int currentIdx = 1;
    int start = 0;
    while (currentIdx < total) {
      if (p.charAt(currentIdx) == 'a') {
        if (p.charAt(currentIdx - 1) != 'z') {
          String subStr = p.substring(start, currentIdx);
          allUnique.add(subStr);
          start = currentIdx;
        }
      } else {
        if (p.charAt(currentIdx) - p.charAt(currentIdx - 1) != 1) {
          String subStr = p.substring(start, currentIdx);
          allUnique.add(subStr);
          start = currentIdx;
        }
      }
      currentIdx++;
    }
    String subStr = p.substring(start, currentIdx);
    if (subStr.length() > 0) {
      allUnique.add(subStr);
    }
    int result = 0;
    for (String str : allUnique) {
      int len = str.length();
      if (len >= 26) {
        result = result + (len - 26) * 26 + 27 * 26 / 2;
      } else {
        if (len == 1) {
          result++;
        } else {
          result = result + ((len + 1) * len / 2 - len);
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Q467Contest q = new Q467Contest();
    String[] tests = {"abaab",
        "cdefghefghijklmnopqrstuvwxmnijklmnopqrstuvbcdefghijklmnopqrstuvwabcddefghijklfghijklmabcdefghijklmnopqrstuvwxymnopqrstuvwxyz",
        "abaab", "nihptuavvw", "zab", "cac", "a", "abcd", "aabb", "abcdefghijklmnopqrstuvwxyz",
        "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz",
        "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"};
    // 33475, 34151
    for (String test : tests) {
      System.out.println(q.findSubstringInWraproundString3(test));
    }
  }
}
