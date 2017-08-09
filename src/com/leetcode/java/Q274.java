package com.leetcode.java;

import java.util.Arrays;

public class Q274 {

  // O(nlog(n))
  public int hIndex(int[] citations) {
    Arrays.sort(citations);
    int count = 1;
    for (int i = citations.length - 1; i >= 0; i--) {
      if (citations[i] >= count) {
        count++;
      } else {
        return count - 1;
      }
    }
    return count - 1;
  }

  public int hIndex2(int[] citations) {
    int[] buckets = new int[citations.length];
    // TODO
    return 0;
  }

  public static void main(String[] args) {
    Q274 q = new Q274();
    int[][] citations = {{0, 0}, {3, 0, 6, 1, 5}};
    for (int i = 0; i < citations.length; i++) {
      System.out.println(q.hIndex(citations[i]));
    }
  }
}
