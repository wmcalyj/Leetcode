package com.leetcode.java;

import com.leetcode.java.Q252Lock.Interval;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q056 {

  /**
   * Definition for an interval.
   * public class Interval {
   *     int start;
   *     int end;
   *     Interval() { start = 0; end = 0; }
   *     Interval(int s, int e) { start = s; end = e; }
   * }
   */
  public class Solution {

    public List<Interval> merge(List<Interval> intervals) {
      if (intervals == null || intervals.isEmpty()) {
        return new ArrayList<Interval>();
      }
      Collections.sort(intervals, new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
          if (o1.start != o2.start) {
            return o1.start - o2.start;
          } else {
            return o1.end - o2.end;
          }
        }
      });
      List<Interval> re = new ArrayList<>();
      re.add(intervals.get(0));
      int current = 0;
      for (int i = 1; i < intervals.size(); i++) {
        Interval tmp = intervals.get(i);
        Interval cur = re.get(current);
        if (tmp.start >= cur.start && tmp.start <= cur.end) {
          cur.end = Math.max(cur.end, tmp.end);
        } else if (tmp.start > cur.end) {
          re.add(tmp);
          current++;
        }
      }
      return re;
    }
  }
}
