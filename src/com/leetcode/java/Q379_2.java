package com.leetcode.java;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// 610 ms
public class Q379_2 {

  Set<Integer> used;
  Queue<Integer> nums;

  /** Initialize your data structure here
   @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
  public Q379_2(int maxNumbers) {
    used = new HashSet<Integer>();
    nums = new LinkedList<Integer>();
    for (int i = 0; i < maxNumbers; i++) {
      nums.offer(i);
    }
  }

  /** Provide a number which is not assigned to anyone.
   @return - Return an available number. Return -1 if none is available. */
  public int get() {
    if (nums.isEmpty()) {
      return -1;
    }
    Integer newN = nums.poll();
    used.add(newN);
    return newN;

  }

  /** Check if a number is available or not. */
  public boolean check(int number) {
    return !used.contains(number);
  }

  /** Recycle or release a number. */
  public void release(int number) {
    if (used.contains(number)) {
      used.remove(number);
      nums.offer(number);
    }
  }
}
