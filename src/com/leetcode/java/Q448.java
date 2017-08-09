package com.leetcode.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 *

 Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

 Find all the elements of [1, n] inclusive that do not appear in this array.

 Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

 Example:

 Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [5,6]

 *
 * @author mengchaowang
 *
 */
public class Q448 {

  public List<Integer> findDisappearedNumbers(int[] nums) {
    int n = nums.length;
    Set<Integer> set = new HashSet<Integer>();
    for (int i = 0; i < n; i++) {
      set.add(i + 1);
    }
    for (int i = 0; i < n; i++) {
      set.remove(nums[i]);
    }

    return new ArrayList<Integer>(set);
  }

  public List<Integer> findDisappearedNumbers2(int[] nums) {
    // The following step is to negate value
    // Change [4, 3, 2, 7, 8, 2, 3, 1] to [-4, -3, -2, -7, 8, 2, -3, -1]
    for (int i = 0; i < nums.length; i++) {
      int idx = Math.abs(nums[i]) - 1;
      nums[idx] = Math.abs(nums[idx]) * -1;

    }
    List<Integer> result = new ArrayList<Integer>();
    // Scan nums and find any positive value;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] >= 0) {
        result.add(i + 1);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Q448 q = new Q448();
    int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

    List<Integer> result = q.findDisappearedNumbers2(nums);
    for (int r : result) {
      System.out.print(r + " ");
    }
  }
}
