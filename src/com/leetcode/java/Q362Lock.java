package com.leetcode.java;

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
public class Q362Lock {

  int[] hits = new int[301];
  int prevHit = 0;

  /** Initialize your data structure here. */
  public Q362Lock() {

  }

  /** Record a hit.
   @param timestamp - The current timestamp (in seconds granularity). */
  public void hit(int timestamp) {
    if (timestamp - prevHit >= 300) {
      for (int i = 1; i < hits.length; i++) {
        hits[i] = 0;
      }
    } else {
      if (timestamp > 300) {
        for (int i = 1; i <= timestamp % 301; i++) {
          hits[i] = 0;
        }
      }
    }
    hits[timestamp % 301]++;
    prevHit = timestamp;
    System.out.println("hits[" + timestamp + "] - " + hits[timestamp] + ", prevHit - " + prevHit);
  }

  /** Return the number of hits in the past 5 minutes.
   @param timestamp - The current timestamp (in seconds granularity). */
  public int getHits(int timestamp) {
    if (timestamp - prevHit >= 300) {
      for (int i = 1; i < hits.length; i++) {
        hits[i] = 0;
      }
    } else {
      if (timestamp > 300) {
        for (int i = 1; i <= timestamp % 301; i++) {
          hits[i] = 0;
        }
      }
    }
    int sum = 0;
    for (int i = 1; i <= 300; i++) {
      sum += hits[i];
    }
    return sum;

  }

  public static void main(String[] args) {
    Q362Lock q = new Q362Lock();
    q.hit(1);
    q.hit(2);
    q.hit(3);
    System.out.println(q.getHits(4));
    q.hit(300);
    System.out.println(q.getHits(300));
    System.out.println(q.getHits(301));

  }
}
