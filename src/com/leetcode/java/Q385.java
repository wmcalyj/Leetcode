package com.leetcode.java;

/**
 *
 *

 Given a nested list of integers represented as a string, implement a parser to deserialize it.

 Each element is either an integer, or a list -- whose elements may also be integers or other lists.

 Note: You may assume that the string is well-formed:

 String is non-empty.
 String does not contain white spaces.
 String contains only digits 0-9, [, - ,, ].
 Example 1:

 Given s = "324",

 You should return a NestedInteger object which contains a single integer 324.
 Example 2:

 Given s = "[123,[456,[789]]]",

 Return a NestedInteger object containing a nested list with 2 elements:

 1. An integer containing value 123.
 2. A nested list containing two elements:
 i.  An integer containing value 456.
 ii. A nested list with one element:
 a. An integer containing value 789.


 *
 * @author mengchaowang
 *
 */
public class Q385 {

  public NestedInteger deserialize(String s) {
    if (s == null || s.length() == 0) {
      return new NestedInteger();
    }
    if (s.charAt(0) != '[') {
      return new NestedInteger(Integer.valueOf(s));
    }
    NestedInteger n = new NestedInteger();
    int leftB = s.indexOf('[');
    int rightB = s.lastIndexOf(']');
    String sub = s.substring(leftB + 1, rightB);
    int idx = -1;
    for (int i = 0; i < sub.length(); i++) {
      if (Character.isDigit(sub.charAt(i))) {
        if (idx == -1) {
          idx = i;
        }
      } else {
        if (sub.charAt(i) == '[') {
          int close = sub.lastIndexOf(']');
          n.add(deserialize(sub.substring(i, close + 1)));
        }
        if (sub.charAt(i) == ',') {
          int num = Integer.valueOf(sub.substring(idx, i));
          n.add(new NestedInteger(num));
        }
        idx = -1;
      }
    }
    if (idx != -1) {

    }
    return n;
  }
}
