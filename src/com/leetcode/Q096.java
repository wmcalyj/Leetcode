package com.leetcode;

/**
 * 
 * 
  
 Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3 
  
 * 
 * @author mengchaowang
 *
 */
public class Q096 {
	public int numTrees(int n) {
		int[] trees = new int[n + 1];
		trees[0] = 1;
		trees[1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++)
				trees[i] += trees[j - 1] * trees[i - j];
		}
		return trees[n];

	}
}
