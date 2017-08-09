package com.leetcode.java;

/**
 * Created by mengchaowang on 6/17/17.
 */

/**

 Given m arrays, and each array is sorted in ascending order. Now you can pick up two integers from two different arrays (each array picks one) and calculate the distance. We define the distance between two integers a and b to be their absolute difference |a-b|. Your task is to find the maximum distance.

 Example 1:
 Input:
 [[1,2,3],
 [4,5],
 [1,2,3]]
 Output: 4
 Explanation:
 One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
 Note:
 Each given array will have at least 1 number. There will be at least two non-empty arrays.
 The total number of the integers in all the m arrays will be in the range of [2, 10000].
 The integers in the m arrays will be in the range of [-10000, 10000].

 */
public class Q624 {

  public int maxDistance(int[][] arrays) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    int minI = 0, maxI = 0;
    for (int i = 0; i < arrays.length; i++) {
      if (arrays[i][0] < min) {
        minI = i;
        min = arrays[i][0];
      }
      if (arrays[i][arrays[i].length - 1] > max) {
        maxI = i;
        max = arrays[i][arrays[i].length - 1];
      }
    }
    if (minI != maxI) {
      return Math.abs(max - min);
    } else {
      int diff1 = 0, diff2 = 0;
      int tmpMax = Integer.MIN_VALUE;
      int tmpMin = Integer.MAX_VALUE;
      for (int i = 0; i < arrays.length; i++) {
        if (arrays[i][arrays[i].length - 1] > tmpMax && i != minI) {
          tmpMax = arrays[i][arrays[i].length - 1];
        }
      }
      diff1 = Math.abs(tmpMax - min);
      for (int i = 0; i < arrays.length; i++) {
        if (arrays[i][0] < tmpMin && i != minI) {
          tmpMin = arrays[i][0];
        }
      }
      diff2 = Math.abs(max - tmpMin);
      return Integer.max(diff1, diff2);
    }
  }
}
