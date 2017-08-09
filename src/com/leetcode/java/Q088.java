package com.leetcode.java;

/**
 *

 Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array. 

 *
 * @author mengchaowang
 *
 */
public class Q088 {

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int tail = nums1.length - 1;
    while (m > 0 && n > 0) {
      if (nums1[m - 1] > nums2[n - 1]) {
        nums1[tail] = nums1[m - 1];
        m--;
      } else {
        nums1[tail] = nums2[n - 1];
        n--;
      }
      tail--;
    }
    while (m > 0) {
      nums1[tail--] = nums1[m - 1];
      m--;
    }
    while (n > 0) {
      nums1[tail--] = nums2[n - 1];
      n--;
    }
  }

}
