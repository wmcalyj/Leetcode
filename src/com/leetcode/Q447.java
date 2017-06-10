package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
  
 Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:
Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 
  
 * 
 * @author mengchaowang
 *
 */
public class Q447 {

	public int numberOfBoomerangs(int[][] points) {
		int re = 0;
		for (int i = 0; i < points.length; i++) {
			Map<Double, Integer> map = new HashMap<Double, Integer>();
			for (int j = 0; j < points.length; j++) {
				if (i == j)
					continue;
				Double distance = getDistance(points[i], points[j]);
				Integer counts = map.containsKey(distance) ? map.get(distance) + 1 : 1;
				map.put(distance, counts);
			}
			for (Double distance : map.keySet()) {
				re += processCounts(map.get(distance));
			}
		}
		return re;
	}

	private int processCounts(Integer counts) {
		return counts * (counts - 1);
	}

	private Double getDistance(int[] p1, int[] p2) {
		return Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2);
	}

	public static void main(String[] args) {
		Q447 q = new Q447();
		int[][][] tests = { { { 0, 0 }, { 1, 0 }, { 2, 0 } }, { { 0, 0 }, { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } } };
		for (int i = 0; i < tests.length; i++) {
			System.out.println(q.numberOfBoomerangs(tests[i]));
		}
	}
}
