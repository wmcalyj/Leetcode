package com.leetcode;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * 
 * Example 1: Input: [7, 1, 5, 3, 6, 4] Output: 5
 * 
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger
 * than buying price) Example 2: Input: [7, 6, 4, 3, 1] Output: 0
 * 
 * In this case, no transaction is done, i.e. max profit = 0.
 * 
 * @author mengchaowang
 *
 */
public class Q121 {
	public int maxProfit(int[] prices) {
		int in = -1;
		int out = -1;
		int max = 0;
		for (int i = 0; i < prices.length; i++) {
			if (in == -1) {
				in = prices[i];
			} else {
				if (prices[i] > in) {
					if (out == -1) {
						out = prices[i];
						max = out - in > max ? out - in : max;
					} else {
						if (prices[i] > out) {
							out = prices[i];
							max = out - in > max ? out - in : max;
						}
					}
				} else {
					in = prices[i];
					out = -1;
				}
			}
		}
		max = out - in > max ? out - in : max;

		return max;
	}

	public static void main(String[] args) {
		Q121 q = new Q121();
		int[] n1 = { 7, 1, 5, 3, 6, 4 };
		int[] n2 = { 7, 6, 4, 3, 1 };
		int[] n3 = { 2, 2, 5 };
		int[] n4 = { 3, 3 };
		int[] n5 = { 3, 3, 5, 0, 0, 3, 1, 4 };
		int[] n6 = { 9, 9, 0, 3, 0, 7, 7, 7, 4, 1, 5, 0, 1, 7 };
		int[] n7 = { 2, 4, 1 };
		int[] n8 = { 3, 2, 6, 5, 0, 3 };
		System.out.println(q.maxProfit(n1));
		System.out.println(q.maxProfit(n2));
		System.out.println(q.maxProfit(n3));
		System.out.println(q.maxProfit(n4));
		System.out.println(q.maxProfit(n5));
		System.out.println(q.maxProfit(n6));
		System.out.println(q.maxProfit(n7));
		System.out.println(q.maxProfit(n8));

	}
}
