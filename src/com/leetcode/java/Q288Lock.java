package com.leetcode.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * An abbreviation of a word follows the form <first letter><number><last
 * letter>. Below are some examples of word abbreviations:
 *
 * a) it --> it (no abbreviation)
 *
 * -----1
 *
 * b) d|o|g --> d1g
 *
 * --------------1----1--1
 *
 * -----1---5----0----5--8
 *
 * c) i|nternationalizatio|n --> i18n
 *
 * --------------1
 *
 * -----1---5----0
 *
 * d) l|ocalizatio|n --> l10n
 *
 * Assume you have a dictionary and given a word, find whether its abbreviation
 * is unique in the dictionary. A word's abbreviation is unique if no other word
 * from the dictionary has the same abbreviation.
 *
 * Example: Given dictionary = [ "deer", "door", "cake", "card" ]
 *
 * isUnique("dear") -> false
 *
 * isUnique("cart") -> true
 *
 * isUnique("cane") -> false
 *
 * isUnique("make") -> true
 *
 * @author mengchaowang
 *
 */
public class Q288Lock {

  Map<String, Set<String>> dict = new HashMap<String, Set<String>>();

  public Q288Lock(String[] dictionary) {
    for (String s : dictionary) {
      String abbr = getAbbr(s);
      Set<String> count = dict.get(abbr);
      if (count == null) {
        count = new HashSet<String>();
      }
      count.add(s);
      dict.put(abbr, count);
    }

  }

  public boolean isUnique(String word) {
    String abbr = getAbbr(word);
    Set<String> count = dict.get(abbr);
    if (count == null || (count.size() == 1 && count.contains(word))) {
      return true;
    }
    return false;
  }

  private String getAbbr(String s) {
    if (s.length() == 0) {
      return "";
    }
    if (s.length() <= 2) {
      return s;
    }
    StringBuilder sb = new StringBuilder();
    sb.append(s.charAt(0)).append(s.length() - 2).append(s.charAt(s.length() - 1));
    return sb.toString();
  }
}
