package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
  
 Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.

Note: 
You may assume that n is always positive.
Factors should be greater than 1 and less than n.
Examples: 
input: 1
output: 
[]
input: 37
output: 
[]
input: 12
output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]
input: 32
output:
[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
] 
  
 * 
 * 
 */
public class Q254Lock {
	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		getFactors(n, result, new ArrayList<Integer>());
		return result;
	}

	public void getFactors(int n, List<List<Integer>> result, List<Integer> tmpResult) {
		if (n <= 1) {
			result.add(tmpResult);
			return;
		}
		int sqrt = (int) Math.pow(n, 0.5);
		for (int i = 2; i <= sqrt; i++) {
			if (n % i == 0) {
				tmpResult.add(i);
				getFactors(n / i, result, tmpResult);
				tmpResult.add(n / i);
				result.add(tmpResult);
				break;
			}
		}
	}

	public static void main(String[] args) {
		Q254Lock q = new Q254Lock();
		List<List<Integer>> n = q.getFactors(12);
		for (int i = 0; i < n.size(); i++) {
			System.out.print("[");
			for (int j = 0; j < n.get(i).size(); j++) {
				System.out.print(n.get(i).get(j) + ", ");
			}
			System.out.println("]");
		}
	}
}
