package com.leetcode;

import java.util.Comparator;

/**
 * 
 * 
  
 Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources, it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.

You are given several projects. For each project i, it has a pure profit Pi and a minimum capital of Ci is needed to start the corresponding project. Initially, you have W capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.

To sum up, pick a list of at most k distinct projects from given projects to maximize your final capital, and output your final maximized capital.

Example 1:
Input: k=2, W=0, Profits=[1,2,3], Capital=[0,1,1].

Output: 4

Explanation: Since your initial capital is 0, you can only start the project indexed 0.
             After finishing it you will obtain profit 1 and your capital becomes 1.
             With capital 1, you can either start the project indexed 1 or the project indexed 2.
             Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
             Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.
Note:
You may assume all numbers in the input are non-negative integers.
The length of Profits array and Capital array will not exceed 50,000.
The answer is guaranteed to fit in a 32-bit signed integer. 
  
 * 
 * @author mengchaowang
 *
 */
public class Q502 {
	private class CapitalProfit {
		int cap;
		int profit;
	}

	public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
		new Comparator<CapitalProfit>() {

			@Override
			public int compare(CapitalProfit o1, CapitalProfit o2) {
				if (o1 != o2) {
					return o1.cap - o2.cap;
				} else {
					return o2.profit - o1.profit;
				}
			}

		};
		if (k <= 0) {
			return W;
		}
		int currentMax = 0;
		int maxPos = -1;
		boolean allUsed = true;
		for (int i = 0; i < Capital.length; i++) {
			if (Capital[i] >= 0) {
				allUsed = false;
			}
			if (Capital[i] >= 0 && Capital[i] <= W && Profits[i] >= currentMax) {
				currentMax = Profits[i];
				maxPos = i;
			}
		}
		if (allUsed) {
			return W;
		}
		if (maxPos == -1) {
			return currentMax;
		} else {
			Capital[maxPos] = -1;
			return findMaximizedCapital(k - 1, W + currentMax, Profits, Capital);
		}
	}

	public static void main(String[] args) {
		int[] ks = { 10 };
		int[] Ws = { 0 };
		int[][] Profitss = { { 1, 2, 3 } };
		int[][] Capitals = { { 0, 1, 2 } };
		Q502 q = new Q502();
		for (int i = 0; i < ks.length; i++) {
			System.out.println(q.findMaximizedCapital(ks[i], Ws[i], Profitss[i], Capitals[i]));
		}
	}
}
