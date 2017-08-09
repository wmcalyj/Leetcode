package com.leetcode.java;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, determine if a permutation of the string could form a
 * palindrome.
 *
 * For example, "code" -> False, "aab" -> True, "carerac" -> True.
 *
 * @author mengchaowang
 *
 */
public class Q266Lock {

  public boolean canPermutePalindrome(String s) {
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    for (int i = 0; i < s.length(); i++) {
      Integer value = map.get(s.charAt(i));
      if (value == null) {
        map.put(s.charAt(i), 1);
      } else {
        map.put(s.charAt(i), value + 1);
      }
    }
    if (s.length() % 2 == 0) {
      for (Integer i : map.values()) {
        if (i % 2 != 0) {
          return false;
        }
      }
    } else {
      int odd = 0;
      for (Integer i : map.values()) {
        if (i % 2 != 0) {
          odd++;
        }
        if (odd > 1) {
          return false;
        }
      }
    }
    return true;
  }
}
