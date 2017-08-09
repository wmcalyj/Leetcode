package com.leetcode.java;

/**
 * Created by mengchaowang on 7/1/17.

 Given a string containing only digits, restore it by returning all possible valid IP address combinations.

 For example:
 Given "25525511135",

 return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

 */
//public class Q093 {
//
//  public List<String> restoreIpAddresses(String s) {
//    List<String> re = new ArrayList<>();
//
//    return re;
//  }
//
//  public List<String> ipAddress(String preStr, String postStr, int left) {
//    if (postStr.length() > left * 3) {
//      return "";
//    }
//    if (left == 0) {
//      return preStr;
//    }
//    int i = 1;
//    while (i < postStr.length()) {
//      String solution = ipAddress(postStr.substring(0, i), postStr.substring(i), left--);
//      if (solution.isEmpty()) {
//        return "";
//      } else {
//
//      }
//    }
//
//  }
//}
