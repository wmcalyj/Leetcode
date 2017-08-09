package com.leetcode.java;

/**
 *
 *

 Given an array of integers A and let n to be its length.

 Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:

 F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].

 Calculate the maximum value of F(0), F(1), ..., F(n-1).

 Note:
 n is guaranteed to be less than 105.

 Example:

 A = [4, 3, 2, 6]

 F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26

 So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.

 * @author mengchaowang
 *
 */
public class Q396Contest {

  public int maxRotateFunction(int[] A) {
    if (A.length == 0) {
      return 0;
    }
    int max = Integer.MIN_VALUE;
    int length = A.length;
    int tmp = 0;
    for (int i = 0; i < length; i++) {
      print(A);
      for (int j = 0; j < length; j++) {
        tmp += j * A[j];
      }
      System.out.println("tmp: " + tmp);
      if (tmp > max) {
        max = tmp;
      }
      rotate(A, length);
      tmp = 0;
    }
    return max;
  }

  public void rotate(int[] A, int length) {
    int tmp = A[length - 1];
    for (int i = length - 1; i > 0; i--) {
      A[i] = A[i - 1];
    }
    A[0] = tmp;
  }

  public static void print(int[] A) {
    for (int i = 0; i < A.length; i++) {
      System.out.print(A[i] + ", ");
    }
  }

  public static void main(String[] args) {
    Q396Contest q = new Q396Contest();
    int[] a = {4, 3, 2, 6};
    int[] a2 = {1, 2};
    int[] a3 = {-2147483648, -2147483648};
    System.out.println(q.maxRotateFunction(a3));
  }
}
