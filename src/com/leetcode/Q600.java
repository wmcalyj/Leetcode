package com.leetcode;

/**
 * 
  
 Given a positive integer n, find the number of non-negative integers less than or equal to n, whose binary representations do NOT contain consecutive ones.

Example 1:
Input: 5
Output: 5
Explanation: 
Here are the non-negative integers <= 5 with their corresponding binary representations:
0 : 0
1 : 1
2 : 10
3 : 11
4 : 100
5 : 101
Among them, only integer 3 disobeys the rule (two consecutive ones) and the other 5 satisfy the rule.  
  
  
 * @author mengchaowang
 *
 */
public class Q600 {
	public int findIntegers(int num) {
		int[] re = new int[num + 1];
		int idx = 0;
		while (idx <= num) {
			if (re[idx] == -1) {
				idx++;
				continue;
			}
			if (invalid(idx)) {
				int tmp = idx;
				while (tmp <= num) {
					re[tmp] = -1;
					tmp *= 2;
				}
			}
			idx++;
		}
		int count = 0;
		for (int i = 0; i <= num; i++) {
			if (re[i] == -1) {
				count++;
			}
		}
		return num + 1 - count;
	}

	private boolean invalid(int idx) {
		int tmp = 0;
		while (idx > 0) {
			if (idx % 2 == 0) {
				tmp = 0;
			} else {
				tmp++;
				if (tmp >= 2) {
					return true;
				}
			}
			idx /= 2;
		}
		return false;
	}

	public static void main(String[] args) {
		Q600 q = new Q600();
		System.out.println(q.findIntegers(100000000));
	}
}
