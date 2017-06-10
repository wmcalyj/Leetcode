package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 
  
 Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false. 
  
 * 
 * @author mengchaowang
 *
 */
public class Q261Lock {
	public boolean validTree(int n, int[][] edges) {
		if (edges.length == 0) {
			return n <= 1;
		}
		int[] sets = new int[n];
		// Each node is its own parent
		for (int i = 0; i < n; i++) {
			sets[i] = i;
		}

		for (int i = 0; i < edges.length; i++) {
			if (find(sets, edges[i][0], edges[i][1])) {
				return false;
			} else {
				unite(sets, edges[i][0], edges[i][1]);
			}
		}
		Set<Integer> trees = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			trees.add(root(sets, i));
			if (trees.size() > 1) {
				return false;
			}
		}
		return true;
	}

	private void unite(int[] sets, int i, int j) {
		int root = root(sets, j);
		while (sets[i] != i) {
			i = sets[i];
		}
		sets[i] = root;
	}

	private boolean find(int[] sets, int i, int j) {
		return root(sets, sets[i]) == root(sets, sets[j]);
	}

	private int root(int[] sets, int i) {
		while (sets[i] != i) {
			sets[i] = sets[sets[i]];
			i = sets[i];
		}
		return sets[i];
	}
}
