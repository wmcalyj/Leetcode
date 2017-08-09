package com.leetcode.java;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengchaowang on 6/24/17.
 * <p>
 * There are n different online courses numbered from 1 to n. Each course has some duration(course length) t and closed on dth day. A course should be taken continuously for t days and must be finished before or on the dth day. You will start at the 1st day.
 * <p>
 * Given n online courses represented by pairs (t,d), your task is to find the maximal number of courses that can be taken.
 * <p>
 * Example:
 * Input: [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]
 * Output: 3
 * Explanation:
 * There're totally 4 courses, but you can take 3 courses at most:
 * First, take the 1st course, it costs 100 days so you will finish it on the 100th day, and ready to take the next course on the 101st day.
 * Second, take the 3rd course, it costs 1000 days so you will finish it on the 1100th day, and ready to take the next course on the 1101st day.
 * (If you take the 2nd course here, you will end at 300th day and find that no more courses you could take.)
 * Third, take the 2nd course, it costs 200 days so you will finish it on the 1300th day.
 * The 4th course cannot be taken now, since you will finish it on the 3300th day, which exceeds the closed date.
 */
public class Q630 {

  public static void main(String[] args) {
    Q630 q = new Q630();

  }

  public int scheduleCourse(int[][] courses) {
    Map<Integer, int[]> idxToMap = new HashMap<>();

    for (int i = 0; i < courses.length; i++) {
      idxToMap.put(i, courses[i]);
    }

    return takeCourse(idxToMap, 0);
  }


  public int takeCourse(Map<Integer, int[]> courses, int currentDay) {
//        if (courses.isEmpty()) {
//            return 0;
//        }
//        int count = 0;
//        int[] course = courses.poll();
//        if (currentDay + course[0] < course[1]) {
//            count = Integer.max(takeCourse(courses, currentDay), takeCourse(courses, currentDay + course[0]));
//        } else {
//            count = Integer.max(count, takeCourse(courses, currentDay));
//        }
//        return count;
    return 0;

  }


}
