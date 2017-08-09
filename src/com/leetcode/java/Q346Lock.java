package com.leetcode.java;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a stream of integers and a window size, calculate the moving average of
 * all integers in the sliding window.
 *
 * For example,
 *
 * MovingAverage m = new MovingAverage(3);
 *
 * m.next(1) = 1
 *
 * m.next(10) = (1 + 10) / 2
 *
 * m.next(3) = (1 + 10 + 3) / 3
 *
 * m.next(5) = (10 + 3 + 5) / 3
 *
 * @author mengchaowang
 *
 */
public class Q346Lock {

  Queue<Integer> queue;
  int size;
  double currentValue;

  /** Initialize your data structure here. */
  public Q346Lock(int size) {
    queue = new LinkedList<Integer>();
    this.size = size;
    this.currentValue = 0.0;
  }

  public double next(int val) {
    if (queue.size() < size) {
      queue.offer(val);
      currentValue = (currentValue * (queue.size() - 1) + val) / queue.size();
    } else {
      int out = queue.remove();
      queue.offer(val);
      currentValue = (currentValue * queue.size() - out + val) / queue.size();
    }
    return currentValue;
  }
}
