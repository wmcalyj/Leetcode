package com.leetcode.java;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180
 * degrees (looked at upside down).
 *
 * Write a function to determine if a number is strobogrammatic. The number is
 * represented as a string.
 *
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 *
 * @author mengchaowang
 *
 */
public class Q246Lock {

  int[] list = new int[10];

  public boolean isStrobogrammatic(String num) {
    for (int i = 0; i < 10; i++) {
      list[i] = -1;
    }
    list[0] = 0;
    list[1] = 1;
    list[6] = 9;
    list[8] = 8;
    list[9] = 6;

    StringBuilder newString = new StringBuilder();
    for (int i = 0; i < num.length(); i++) {
      int indexVal = Integer.parseInt(String.valueOf(num.charAt(i)));
      int newVal = list[indexVal];
      if (newVal == -1) {
        return false;
      }
      newString.insert(0, newVal);
    }
    return newString.toString().equals(num);

  }
}
