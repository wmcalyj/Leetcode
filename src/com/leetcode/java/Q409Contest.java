package com.leetcode.java;

import java.util.HashMap;
import java.util.Map;

/**
 *

 Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

 This is case sensitive, for example "Aa" is not considered a palindrome here.

 Note:
 Assume the length of given string will not exceed 1,010.

 Example:

 Input:
 "abccccdd"

 Output:
 7

 Explanation:
 One longest palindrome that can be built is "dccaccd", whose length is 7.

 *
 * @author mengchaowang
 *
 */
public class Q409Contest {

  public int longestPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      int count = map.containsKey(c) ? map.get(c) + 1 : 1;
      map.put(c, count);
    }
    int total = 0;
    boolean hasSingle = false;
    for (Integer value : map.values()) {
      if (value % 2 == 0) {
        total += value;
      } else {
        hasSingle = true;
        total = total + value - 1;
      }
    }
    return hasSingle ? total + 1 : total;
  }

  public static void main(String[] args) {
    Q409Contest q = new Q409Contest();
    String[] strs = {"abccccdd", "", "AaBb", "BB",
        "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"};
    for (int i = 0; i < strs.length; i++) {
      System.out.println(q.longestPalindrome(strs[i]));
    }
  }
}
