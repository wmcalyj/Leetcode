package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
  
 There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have the same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.

The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick in this row from left to right.

If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.

You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.

Example:
Input: 
[[1,2,2,1],
 [3,1,2],
 [1,3,2],
 [2,4],
 [3,1,2],
 [1,3,1,1]]
Output: 2
Explanation: 

Note:
The width sum of bricks in different rows are the same and won't exceed INT_MAX.
The number of bricks in each row is in range [1,10,000]. The height of wall is in range [1,10,000]. Total number of bricks of the wall won't exceed 20,000. 
  
 * 
 * @author mengchaowang
 *
 */
public class Q554 {
	public int leastBricks(List<List<Integer>> wall) {
		Map<Integer, Integer> gapLevel = new HashMap<Integer, Integer>();
		int totalRows = wall.size();
		int width = 0;
		for (List<Integer> row : wall) {
			int rowSum = 0;
			for (Integer brick : row) {
				rowSum += brick;
				int count = gapLevel.containsKey(rowSum) ? gapLevel.get(rowSum) : 0;
				count++;
				gapLevel.put(rowSum, count);
			}
			width = rowSum;
		}
		gapLevel.remove(width);
		int maxCount = 0;
		for (int value : gapLevel.values()) {
			if (value > maxCount) {
				maxCount = value;
			}
		}
		return totalRows - maxCount;
	}

	public static void main(String[] args) {
		Q554 q = new Q554();
		int[][] wall = { { 1, 2, 2, 1 }, { 3, 1, 2 }, { 1, 3, 2 }, { 2, 4 }, { 3, 1, 2 }, { 1, 3, 1, 1 } };
		System.out.println(q.leastBricks(convert(wall)));
	}

	private static List<List<Integer>> convert(int[][] wall) {
		List<List<Integer>> re = new ArrayList<List<Integer>>();
		for (int i = 0; i < wall.length; i++) {
			List<Integer> row = new ArrayList<Integer>();
			for (int j = 0; j < wall[i].length; j++) {
				row.add(wall[i][j]);
			}
			re.add(row);
		}
		return re;
	}
}
