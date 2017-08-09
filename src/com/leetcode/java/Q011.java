package com.leetcode.java;

/**
 *
 *

 Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 Note: You may not slant the container.

 *
 * @author mengchaowang
 *
 */
public class Q011 {

  public int maxArea(int[] height) {
    if (height.length < 2) {
      return 0;
    }
    int start = 0;
    int end = height.length - 1;
    int area = 0;
    while (start < end) {
      int width = end - start;
      int h = Math.min(height[start], height[end]);
      area = Math.max(area, width * h);
      start++;
      end--;
    }
    return area;

  }
}
