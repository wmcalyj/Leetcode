package com.leetcode.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *

 A string such as "word" contains the following abbreviations:

 ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 Given a target string and a set of strings in a dictionary, find an abbreviation of this target string with the smallest possible length such that it does not conflict with abbreviations of the strings in the dictionary.

 Each number or letter in the abbreviation is considered length = 1. For example, the abbreviation "a32bc" has length = 4.

 Note:
 In the case of multiple answers as shown in the second example below, you may return any one of them.
 Assume length of target string = m, and dictionary size = n. You may assume that m ≤ 21, n ≤ 1000, and log2(n) + m ≤ 20.
 Examples:
 "apple", ["blade"] -> "a4" (because "5" or "4e" conflicts with "blade")

 "apple", ["plain", "amber", "blade"] -> "1p3" (other valid answers include "ap3", "a3e", "2p2", "3le", "3l1").

 * @author mengchaowang
 *
 */
public class Q413Contest {

  public String minAbbreviation(String target, List<String> dictionary) {
    Set<String> allAbbrs = new HashSet<String>();
    for (String s : dictionary) {
      getAbbr(s, "", allAbbrs);
    }
    Set<String> targetAbbr = new HashSet<String>();
    getAbbr(target, "", targetAbbr);
    String[] results = new String[targetAbbr.size()];
    targetAbbr.toArray(results);
    Arrays.sort(results, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        int l1 = 0, l2 = 0;
        for (int i = 0; i < o1.length(); i++) {
          l1++;
          while (i < o1.length() && Character.isDigit(o1.charAt(i))) {
            i++;
          }
        }

        for (int i = 0; i < o2.length(); i++) {
          l2++;
          while (i < o2.length() && Character.isDigit(o2.charAt(i))) {
            i++;
          }
        }
        return l1 - l2;
      }
    });
    for (int i = 0; i < results.length; i++) {
      if (!allAbbrs.contains(results[i])) {
        return results[i];
      }
    }
    return "ERROR";
  }

  private void getAbbr(String s, String tmpResult, Set<String> abbr) {
    if (s.length() == 0) {
      abbr.add(tmpResult);
    }
    for (int i = 0; i < s.length(); i++) {
      getAbbr(s.substring(i + 1), tmpResult + (i + 1), abbr);
      getAbbr(s.substring(i + 1), tmpResult + s.substring(0, i + 1), abbr);
    }
  }

  public static void main(String[] args) {
    Q413Contest q = new Q413Contest();
    String[] words = {"apple"};
    String[][] dicts = {{"plain", "amber", "blade"}};
    for (int i = 0; i < words.length; i++) {
      System.out.println(q.minAbbreviation(words[i], Arrays.asList("plain", "amber", "blade")));
    }
  }

}
