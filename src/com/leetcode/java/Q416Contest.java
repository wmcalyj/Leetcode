package com.leetcode.java;

/**
 *

 Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

 Note:
 Both the array size and each of the array element will not exceed 100.

 Example 1:

 Input: [1, 5, 11, 5]

 Output: true

 Explanation: The array can be partitioned as [1, 5, 5] and [11].
 Example 2:

 Input: [1, 2, 3, 5]

 Output: false

 Explanation: The array cannot be partitioned into equal sum subsets.


 * @author mengchaowang
 *
 */
public class Q416Contest {

  public boolean canPartition(int[] nums) {
    int total = 0;
    for (int num : nums) {
      total += num;
    }
    return find(nums, 0, 0, total);

  }

  public boolean find(int[] nums, int currentIdx, int tmpLeft, int tmpRight) {
    if (currentIdx >= nums.length) {
      return tmpLeft == tmpRight;
    } else {
      return find(nums, currentIdx + 1, tmpLeft + nums[currentIdx], tmpRight -
          nums[currentIdx]) ||
          find(nums, currentIdx + 1, tmpLeft, tmpRight);
    }
  }

  public static void main(String[] args) {
    Q416Contest q = new Q416Contest();
    int[][] nums = {{1, 5, 11, 5}, {1, 2, 3, 5}};
    for (int i = 0; i < nums.length; i++) {
      System.out.println(q.canPartition(nums[i]));
    }
  }

}
