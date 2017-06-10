package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
  
 Given integers n and k, find the lexicographically k-th smallest integer in the range from 1 to n.

Note: 1 ≤ k ≤ n ≤ 109.

Example:

Input:
n: 13   k: 2

Output:
10

Explanation:
The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10. 
  
 * 
 * @author mengchaowang
 *
 */
public class Q440Contest {
	public int findKthNumber(int n, int k) {
		PriorityQueue<String> q = new PriorityQueue<String>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		for (int i = 1; i <= n; i++) {
			if (i <= k) {
				q.add(String.valueOf(i));
			} else {
				String str = String.valueOf(i);
				if (str.compareTo(q.peek()) < 0) {
					q.remove();
					q.add(String.valueOf(i));
				}
			}
		}
		return Integer.valueOf(q.peek());
	}

	public static void main(String[] args) {
		Q440Contest q = new Q440Contest();
		System.out.println(q.findKthNumber(4289384, 1922239));
	}
}
