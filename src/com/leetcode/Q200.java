package com.leetcode;

/**
 * 
  
 Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3

 
  
 * 
 * @author mengchaowang
 *
 */
public class Q200 {

	public int numIslands(char[][] grid) {
		if (grid.length == 0) {
			return 0;
		}
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] != '0' && grid[i][j] != 0) {
					expand(grid, i, j);
					count++;
				}
			}
		}
		return count;
	}

	private void expand(char[][] grid, int i, int j) {
		grid[i][j] = 0;
		if (i < grid.length - 1 && grid[i + 1][j] != '0' && grid[i + 1][j] != 0) {
			expand(grid, i + 1, j);
		}
		if (j < grid[i].length - 1 && grid[i][j + 1] != '0' && grid[i][j + 1] != 0) {
			expand(grid, i, j + 1);
		}
		if (i >= 1 && grid[i - 1][j] != '0' && grid[i - 1][j] != 0) {
			expand(grid, i - 1, j);
		}
		if (j >= 1 && grid[i][j - 1] != '0' && grid[i][j - 1] != 0) {
			expand(grid, i, j - 1);
		}
	}

	public static void main(String[] args) {
		char[][] map1 = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };

		char[][] map2 = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
		char[][] map = { { '1', '1', '1' }, { '0', '1', '0' }, { '1', '1', '1' } };
		Q200 q = new Q200();
		System.out.println(q.numIslands(map));
	}
}
