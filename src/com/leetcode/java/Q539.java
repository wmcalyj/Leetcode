package com.leetcode.java;

import java.util.Comparator;
import java.util.List;

/**
 * Created by mengchaowang on 7/1/17.

 Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.

 Example 1:
 Input: ["23:59","00:00"]
 Output: 1
 Note:
 The number of time points in the given list is at least 2 and won't exceed 20000.
 The input time is legal and ranges from 00:00 to 23:59.

 */
public class Q539 {

  public int findMinDifference(List<String> timePoints) {
    timePoints.sort(Comparator.naturalOrder());
    int min = 1440;
    for (int i = 1; i < timePoints.size(); i++) {
      min = Math.min(min, getTimeDifference(timePoints.get(i), timePoints.get(i - 1)));
    }
    min = Math
        .min(min, getTimeDifference(timePoints.get(0), timePoints.get(timePoints.size() - 1)));
    return min;

  }

  private int getTimeDifference(String sLarger, String sSmaller) {
    String[] larger = sLarger.split(":");
    String[] smaller = sSmaller.split(":");
    int largerMinute = Integer.parseInt(larger[0]) * 60 + Integer.parseInt(larger[1]);
    int smallerMinute = Integer.parseInt(smaller[0]) * 60 + Integer.parseInt(smaller[1]);
    return Math
        .min(Math.abs(largerMinute - smallerMinute), Math.abs(largerMinute + 1439 - smallerMinute));

  }
}
