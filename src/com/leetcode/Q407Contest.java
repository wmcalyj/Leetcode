package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
  
 Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, compute the volume of water it is able to trap after raining.

Note:
Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.

Example:

Given the following 3x6 height map:
[
  [1,4,3,1,3,2],
  [3,2,1,3,2,4],
  [2,3,3,2,3,1]
]

Return 4.

The above image represents the elevation map [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] before the rain.


After the rain, water are trapped between the blocks. The total volume of water trapped is 4. 
  
 * 
 * 
 * @author mengchaowang
 *
 */
public class Q407Contest {
	public int trapRainWater(int[][] heightMap) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < heightMap.length; i++) {
			for (int j = 0; j < heightMap[i].length; j++) {
				if (heightMap[i][j] > max) {
					max = heightMap[i][j];
				}
				if (heightMap[i][j] < min) {
					min = heightMap[i][j];
				}
			}
		}
		int result = 0;
		while (min < max) {
			for (int i = 0; i <= heightMap.length - 1; i++) {
				for (int j = 0; j <= heightMap[i].length - 1; j++) {
					if (heightMap[i][j] == min) {
						if (canHoldRain(heightMap, i, j, i, j)) {
							result++;
						}
						heightMap[i][j]++;
					}
				}
			}
			for (int i = 0; i < heightMap.length; i++) {
				for (int j = 0; j < heightMap[i].length; j++) {
					if (heightMap[i][j] == min) {
						heightMap[i][j]++;
					}
				}
			}
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			for (int i = 0; i < heightMap.length; i++) {
				for (int j = 0; j < heightMap[i].length; j++) {
					if (heightMap[i][j] > max) {
						max = heightMap[i][j];
					}
					if (heightMap[i][j] < min) {
						min = heightMap[i][j];
					}
				}
			}
		}
		return result;
	}

	private boolean canHoldRain(int[][] heightMap, int i, int j, int fromI, int fromJ) {
		int current = heightMap[i][j];
		if (i == 0 || i == heightMap.length - 1 || j == 0 || j == heightMap[i].length - 1) {
			return false;
		}
		Integer[][] arrays;
		Arrays.sort(arrays, new Comparator<T>() {

			@Override
			public int compare(T o1, T o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		if (heightMap[i][j + 1] > current && heightMap[i][j - 1] > current && heightMap[i + 1][j] > current
				&& heightMap[i - 1][j] > current) {
			return true;
		}
		heightMap[i][j]++;
		boolean up = false, down = false, left = false, right = false;
		if (i + 1 != fromI || j == fromJ) {
			if (i == 1 && heightMap[i - 1][j] > current) {
				up = true;
			} else {
				up = canHoldRain(heightMap, i - 1, j, i, j);
			}
		}
		if (i != fromI || j + 1 == fromJ) {
			if (j == 1 && heightMap[i][j - 1] > current) {
				left = true;
			} else {
				left = canHoldRain(heightMap, i, j - 1, i, j);
			}
		}
		if (i - 1 != fromI || j == fromJ) {
			if (i == heightMap.length - 2 && heightMap[i + 1][j] > current) {
				down = true;
			} else {
				down = canHoldRain(heightMap, i + 1, j, i, j);
			}
		}
		if (i != fromI || j - 1 == fromJ) {
			if (j == heightMap[i].length - 2 && heightMap[i][j + 1] > current) {
				right = true;
			} else {
				right = canHoldRain(heightMap, i, j + 1, i, j);
			}
		}
		heightMap[i][j]--;
		return up && down && left && right;
	}

	public static void main(String[] args) {
		Q407Contest q = new Q407Contest();
		int[][] heightMap = { { 1, 4, 3, 1, 3, 2 }, { 3, 2, 1, 3, 2, 4 }, { 2, 3, 3, 2, 3, 1 } };
		int[][] heightMap2 = { { 12, 13, 1, 12 }, { 13, 4, 13, 12 }, { 13, 8, 10, 12 }, { 12, 13, 12, 12 },
				{ 13, 13, 13, 13 } };
		// System.out.println(q.trapRainWater(heightMap));

		System.out.println(q.trapRainWater(heightMap2));
	}
}
