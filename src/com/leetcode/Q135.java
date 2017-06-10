package com.leetcode;

/**
 * 
  
 There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give? 
  
 * 
 * @author mengchaowang
 *
 */
public class Q135 {
	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0)
			return 0;
		int min = Integer.MAX_VALUE;
		int count = 0;
		boolean clear = false;
		while (!clear) {
			for (int i = 0; i < ratings.length; i++) {
				if (ratings[i] > 0) {
					count++;
					min = ratings[i] < min ? ratings[i] : min;
				}
			}
			clear = true;
			for (int i = 0; i < ratings.length; i++) {
				if (ratings[i] > 0) {
					ratings[i] -= min;
					clear = false;
				}
			}
			min = Integer.MAX_VALUE;
		}
		return count;
	}

	public static void main(String[] args) {
		Q135 q = new Q135();
		int[][] ratings = { { 1, 3, 5 } };
		for (int[] rating : ratings) {
			System.out.println(q.candy(rating));
		}
	}
}
