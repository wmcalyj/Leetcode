package com.leetcode.java;

/**
 *
 *

 Given a sorted array of integers nums and integer values a, b and c. Apply a function of the form f(x) = ax2 + bx + c to each element x in the array.

 The returned array must be in sorted order.

 Expected time complexity: O(n)

 Example:
 nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,

 Result: [3, 9, 15, 33]

 nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5

 Result: [-23, -5, 1, 7]

 *
 * @author mengchaowang
 *
 */
public class Q360Lock {

  public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
    if (nums.length == 0) {
      return new int[0];
    }
    boolean positive = a > 0;

    double pole = -1.0 * (b / (2.0 * a));
    int poleIndex = findPoleIndex(nums, pole, 0, nums.length - 1);
    int[] result = new int[nums.length];
    if (a == 0) {
      int j = b > 0 ? 0 : nums.length - 1;
      for (int i = 0; i < nums.length; i++) {
        result[i] = nums[j] * b + c;
        if (b > 0) {
          j++;
        } else {
          j--;
        }
      }
      return result;
    }
    int left = poleIndex;
    int right = poleIndex + 1;
    int i = positive ? 0 : nums.length - 1;
    while (left >= 0 && right < nums.length) {
      int l = nums[left];
      int r = nums[right];
      if (positive) {
        if (Math.abs(l - pole) <= Math.abs(r - pole)) {
          result[i] = a * l * l + b * l + c;
          left--;
        } else if (Math.abs(l - pole) >= Math.abs(r - pole)) {
          result[i] = a * r * r + b * r + c;
          right++;
        }
      } else {
        if (Math.abs(l - pole) <= Math.abs(r - pole)) {
          result[i] = a * l * l + b * l + c;
          left--;
        } else if (Math.abs(l - pole) >= Math.abs(r - pole)) {
          result[i] = a * r * r + b * r + c;
          right++;
        }
      }
      if (positive) {
        i++;
      } else {
        i--;
      }
    }
    while (left >= 0) {
      int l = nums[left--];
      result[i] = a * l * l + b * l + c;
      if (positive) {
        i++;
      } else {
        i--;
      }
    }
    while (right <= nums.length - 1) {
      int r = nums[right++];
      result[i] = a * r * r + b * r + c;
      if (positive) {
        i++;
      } else {
        i--;
      }
    }
    return result;
  }

  private int findPoleIndex(int[] nums, double pole, int start, int end) {
    if (start >= end) {
      return start;
    }
    int middle = (start + end) / 2;
    if (nums[middle] == pole) {
      return middle;
    }
    if (nums[middle] <= pole && nums[middle + 1] > pole) {
      return middle;
    }
    if (nums[middle] < pole) {
      return findPoleIndex(nums, pole, middle + 1, end);
    } else {
      return findPoleIndex(nums, pole, start, middle - 1);
    }
  }

  public static void main(String[] args) {
    Q360Lock q = new Q360Lock();
    int[][] nums = {{-4, -2, 2, 4}, {-4, -2, 2, 4}};
    int[] a = {1, -1};
    int[] b = {3, 3};
    int[] c = {5, 5};
    int[][] results = new int[nums.length][];
    for (int i = 0; i < nums.length; i++) {
      results[i] = q.sortTransformedArray(nums[i], a[i], b[i], c[i]);
    }

    for (int i = 0; i < results.length; i++) {
      System.out.println(i + ": {");
      for (int j = 0; j < results[i].length; j++) {
        System.out.print(results[i][j] + ", ");
      }
      System.out.println("\n}");
    }
  }

}
