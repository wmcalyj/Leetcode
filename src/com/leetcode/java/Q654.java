package com.leetcode.java;
// @formatter:off

/**
 * Created by mengchaowang on 8/5/17.

Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    /
     2  0
       \
        1
Note:
The size of the given array will be in the range [1,1000].


 */

// @formatter:on
public class Q654 {

  final static int LEFT = 0;
  final static int RIGHT = 1;

  public TreeNode constructMaximumBinaryTree(int[] nums) {
    return constructMaximumBinaryTree(nums, 0, nums.length - 1);
  }

  public TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
    if (left > right || right >= nums.length || left >= nums.length || right < 0 || left < 0) {
      return null;
    }
    if (left == right) {
      return new TreeNode(nums[left]);
    }
    int max = nums[left];
    int idx = left;
    for (int i = left + 1; i <= right; i++) {
      if (nums[i] > max) {
        max = nums[i];
        idx = i;
      }
    }
    TreeNode node = new TreeNode(max);
    node.left = constructMaximumBinaryTree(nums, left, idx - 1);
    node.right = constructMaximumBinaryTree(nums, idx + 1, right);
    return node;
  }
}
