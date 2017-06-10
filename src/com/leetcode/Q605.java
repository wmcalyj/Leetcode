package com.leetcode;

/**
 * 
 * 
  
 Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: True
Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2
Output: False
 
  
  
 * 
 * @author mengchaowang
 *
 */
public class Q605 {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		if (n == 0) {
			return true;
		}
		if (flowerbed.length == 1) {
			return flowerbed[0] == 0 && n == 1;
		}
		if (flowerbed.length == 0) {
			return false;
		}
		int count = 0;
		for (int i = 0; i < flowerbed.length; i++) {
			if (flowerbed[i] == 0 && canPut(flowerbed, i)) {
				count++;
			}
		}
		return count >= n;
	}

	private boolean canPut(int[] flowerbed, int i) {
		if (i == 0) {
			if (flowerbed[i + 1] == 0) {
				flowerbed[i] = 1;
				return true;
			}
			return false;
		} else if (i == flowerbed.length - 1) {
			if (flowerbed[i - 1] == 0) {
				flowerbed[i] = 1;
				return true;
			}
			return false;
		} else {
			if (flowerbed[i + 1] == 0 && flowerbed[i - 1] == 0) {
				flowerbed[i] = 1;
				return true;
			}
			return false;
		}
	}

	public static void main(String[] args) {
		Q605 q = new Q605();
		int[][] tests = { { 1, 0, 0, 0, 1 }, { 1, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 0, 1 }, { 1, 0, 0, 0, 1 },
				{ 0, 0, 1, 0, 1 } };
		int[] testsn = { 1, 2, 1, 1, 2, 1 };
		for (int i = 0; i < tests.length; i++) {
			System.out.println(q.canPlaceFlowers(tests[i], testsn[i]));
		}
	}
}
