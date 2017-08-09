package com.leetcode.java;

import java.util.Random;

/**
 *

 Shuffle a set of numbers without duplicates.

 Example:

 // Init an array with set 1, 2, and 3.
 int[] nums = {1,2,3};
 Solution solution = new Solution(nums);

 // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 solution.shuffle();

 // Resets the array back to its original configuration [1,2,3].
 solution.reset();

 // Returns the random shuffling of array [1,2,3].
 solution.shuffle();

 * @author mengchaowang
 *
 */
public class Q384 {

  int[] original, toShuffle;
  Random r;

  public Q384(int[] nums) {
    original = nums;
    toShuffle = new int[nums.length];
    for (int i = 0; i < toShuffle.length; i++) {
      toShuffle[i] = nums[i];
    }
    r = new Random();
  }

  /** Resets the array to its original configuration and return it. */
  public int[] reset() {
    return original;
  }

  /** Returns a random shuffling of the array. */
  public int[] shuffle() {
    int length = toShuffle.length;
    for (int i = 0; i < length; i++) {
      int random = r.nextInt(length);
      swap(toShuffle, i, random);
    }
    return toShuffle;
  }

  private void swap(int[] toShuffle, int i, int random) {
    int tmp = toShuffle[i];
    toShuffle[i] = toShuffle[random];
    toShuffle[random] = tmp;
  }

}
