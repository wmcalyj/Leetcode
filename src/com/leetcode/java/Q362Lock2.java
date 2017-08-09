package com.leetcode.java;

import java.util.HashMap;
import java.util.Map;

/**
 *

 Design a hit counter which counts the number of hits received in the past 5 minutes.

 Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being made to the system in chronological order (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.

 It is possible that several hits arrive roughly at the same time.

 Example:
 HitCounter counter = new HitCounter();

 // hit at timestamp 1.
 counter.hit(1);

 // hit at timestamp 2.
 counter.hit(2);

 // hit at timestamp 3.
 counter.hit(3);

 // get hits at timestamp 4, should return 3.
 counter.getHits(4);

 // hit at timestamp 300.
 counter.hit(300);

 // get hits at timestamp 300, should return 4.
 counter.getHits(300);

 // get hits at timestamp 301, should return 3.
 counter.getHits(301);

 *
 * @author mengchaowang
 *
 */
public class Q362Lock2 {

  Map<Integer, Integer> map;

  /** Initialize your data structure here. */
  public Q362Lock2() {
    map = new HashMap<Integer, Integer>();
  }

  /** Record a hit.
   @param timestamp - The current timestamp (in seconds granularity). */
  /** Record a hit.
   @param timestamp - The current timestamp (in seconds granularity). */
  public void hit(int timestamp) {
    Integer count = map.containsKey(timestamp) ? map.get(timestamp) : 0;
    map.put(timestamp, ++count);
  }

  /** Return the number of hits in the past 5 minutes.
   @param timestamp - The current timestamp (in seconds granularity). */
  public int getHits(int timestamp) {
    int sum = 0;
    for (int i = timestamp - 299; i <= timestamp; i++) {
      if (!map.containsKey(i)) {
        continue;
      } else {
        sum += map.get(i);
      }
    }
    return sum;
  }

  public static void main(String[] args) {
    Q362Lock2 q = new Q362Lock2();
    q.hit(1);
    q.hit(2);
    q.hit(3);
    System.out.println(q.getHits(4));
    q.hit(300);
    System.out.println(q.getHits(300));
    System.out.println(q.getHits(301));

  }
}
