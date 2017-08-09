package com.leetcode.java;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a TwoSum class. It should support the following
 * operations: add and find.
 *
 * add - Add the number to an internal data structure. find - Find if there
 * exists any pair of numbers which sum is equal to the value.
 *
 * @author mengchaowang
 *
 */
public class Q170Lock {

  Map<Integer, Integer> numbers = new HashMap<Integer, Integer>();

  // Add the number to an internal data structure.
  public void add(int number) {
    Integer count = numbers.get(number);
    if (count == null) {
      numbers.put(number, 1);
    } else {
      numbers.put(number, count + 1);
    }
  }

  // Find if there exists any pair of numbers which sum is equal to the value.
  public boolean find(int value) {
    for (Integer n : numbers.keySet()) {
      int another = value - n;
      if (n == another) {
        System.out.println("n - " + n + ", count - " + numbers.get(n));
        if (numbers.get(n) == null) {
          continue;
        } else if (numbers.get(n) != null && numbers.get(n) >= 2) {
          return true;
        } else {
          continue;
        }
      }
      if (numbers.containsKey(value - n)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    Q170Lock q = new Q170Lock();
    q.add(0);
    q.add(0);
    q.find(0);
  }
}
