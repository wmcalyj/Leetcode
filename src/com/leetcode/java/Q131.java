package com.leetcode.java;

import java.util.ArrayList;
import java.util.List;

/**
 *

 Given a string s, partition s such that every substring of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 For example, given s = "aab",
 Return

 [
 ["aa","b"],
 ["a","a","b"]
 ]

 * @author mengchaowang
 *
 */
public class Q131 {

  public List<List<String>> partition(String s) {
    List<List<String>> result = new ArrayList<List<String>>();
    for (int i = 0; i < s.length(); i++) {
      List<String> tmpResult = new ArrayList<String>();
      partition(s.substring(0, i), result, tmpResult);
      partition(s.substring(i), result, tmpResult);
    }
    return result;
  }

  public void partition(String s, List<List<String>> result, List<String> tmpResult) {
    if (s == null || s.length() == 0) {
      result.add(tmpResult);
      return;
    }
    if (isPalindrome(s)) {
      tmpResult.add(s);
    }
    for (int i = 1; i < s.length(); i++) {
      partition(s.substring(0, i), result, tmpResult);
      partition(s.substring(i), result, tmpResult);
    }

  }

  public boolean isPalindrome(String s) {
    int i = 0, j = s.length() - 1;
    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      } else {
        i++;
        j--;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Q131 q = new Q131();
    List<List<String>> result = q.partition("aab");
    for (List<String> list : result) {
      for (String s : list) {
        System.out.print(s + ",");
      }
      System.out.println();
    }
  }
}
