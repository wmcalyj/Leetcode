package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * 
  
 The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that. 
 
 * 
 * @author mengchaowang
 *
 */
public class Q089 {
	public List<Integer> grayCode(int n) {
		List<Integer> re = new ArrayList<Integer>();
		int base = 0;
		re.add(base);
		if (n == 0) {
			return re;
		}
		int i = 0;
		while (true) {
			base = base ^ (int) Math.pow(2, i++);
			if (base != 0) {
				re.add(base);
			} else {
				break;
			}
			if (i == n) {
				i = 0;
			}
		}
		return re;
	}

	public static void main(String[] args) {
		Q089 q = new Q089();
		int[] ns = { 2, 3, 4 };
		for (int n : ns) {
			print(q.grayCode(n));
		}
	}

	private static void print(List<Integer> grayCode) {
		StringBuilder sb = new StringBuilder("[");
		for (int i : grayCode) {
			sb.append(i).append(", ");
		}
		sb.delete(sb.length() - 2, sb.length());
		sb.append("]");
		System.out.println(sb.toString());

	}

}
