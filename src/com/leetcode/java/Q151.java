package com.leetcode.java;

import java.util.Stack;

/**
 *
 *

 Given an input string, reverse the string word by word.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".

 Update (2015-02-12):
 For C programmers: Try to solve it in-place in O(1) space.

 click to show clarification.

 Clarification:
 What constitutes a word?
 A sequence of non-space characters constitutes a word.
 Could the input string contain leading or trailing spaces?
 Yes. However, your reversed string should not contain leading or trailing spaces.
 How about multiple spaces between two words?
 Reduce them to a single space in the reversed string.

 *
 * @author mengchaowang
 *
 */
public class Q151 {

  public String reverseWords(String s) {
    int start = 0;
    int length = s.length();
    int end = length - 1;
    Stack<String> stack = new Stack<String>();
    int i = start;
    while (i <= end) {
      while (i <= end && Character.isSpaceChar(s.charAt(i))) {
        i++;
      }
      if (i > end) {
        break;
      }
      start = i;
      while (i <= end && !Character.isSpaceChar(s.charAt(i))) {
        i++;
      }

      stack.push(s.substring(start, i));
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
      if (!stack.isEmpty()) {
        sb.append(" ");
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    Q151 q = new Q151();
    String[] strs = {"the sky is blue    ", "", "    ", "     a b c    ", "a"};
    for (String s : strs) {
      System.out.println("[" + q.reverseWords(s) + "]");
    }
  }
}
