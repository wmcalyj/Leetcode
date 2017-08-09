package com.leetcode.java;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *

 Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

 Note that it is the kth smallest element in the sorted order, not the kth distinct element.

 Example:

 matrix = [
 [ 1,  5,  9],
 [10, 11, 13],
 [12, 13, 15]
 ],
 k = 8,

 return 13.


 * @author mengchaowang
 *
 */
public class Q378 {

  public int kthSmallest(int[][] matrix, int k) {
    if (matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    if (k <= 0) {
      return matrix[0][0];
    }
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    });
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (maxHeap.size() < k) {
          maxHeap.offer(matrix[i][j]);
        } else {
          if (maxHeap.peek() > matrix[i][j]) {
            maxHeap.poll();
            maxHeap.offer(matrix[i][j]);
          }
        }
      }
    }
    return maxHeap.peek();
  }
}
