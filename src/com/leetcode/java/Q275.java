package com.leetcode.java;

/**
 *

 Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

 Show Hint
 Show Company Tags
 Show Tags
 Show Similar Problems


 *
 * @author mengchaowang
 *
 */
public class Q275 {

  public int hIndex(int[] citations) {
    if (citations.length == 0) {
      return 0;
    }
    int left = 0, right = citations.length - 1;
    int middle = (left + right) / 2;
    int count = citations.length - middle;

    while (left < right) {
      if (citations[middle] <= count && citations[middle + 1] >= count) {
        return count;
      } else if (citations[middle] >= count && middle - 1 >= 0 && citations[middle - 1] < count) {
        return count;
      } else {
        if (citations[middle] > count) {
          right = middle - 1;
        } else {
          left = middle + 1;
        }
      }
      middle = (left + right) / 2;
      count = citations.length - middle;
    }
    return citations[left] >= citations.length ? citations.length : citations.length - left;
  }

  public static void main(String[] args) {
    Q275 q = new Q275();
    int[][] citations = {{0, 1, 2, 3, 4, 5}};
    for (int i = 0; i < citations.length; i++) {
      System.out.println(q.hIndex(citations[i]));
    }
  }
}
