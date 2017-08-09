package com.leetcode.java;

import java.util.HashMap;
import java.util.Map;

/**
 *

 Given a roman numeral, convert it to an integer.

 Input is guaranteed to be within the range from 1 to 3999.

 Show Company Tags
 Show Tags
 Show Similar Problems


 *
 * @author mengchaowang
 *
 */
public class Q013 {

  public int romanToInt(String s) {
    Map<String, Integer> map = new HashMap<String, Integer>();
    map.put("I", 1);
    map.put("V", 5);
    map.put("X", 10);
    map.put("L", 50);
    map.put("C", 100);
    map.put("D", 500);
    map.put("M", 1000);
    map.put("IV", 4);
    map.put("IX", 9);
    map.put("XL", 40);
    map.put("XC", 90);
    map.put("CD", 400);
    map.put("CM", 900);
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      if (i < s.length() - 1 && map.containsKey(s.substring(i, i + 2))) {
        result += map.get(s.substring(i, i + 2));
        i++;
      } else {
        result += map.get(String.valueOf(s.charAt(i)));
      }
    }
    return result;
  }
}
