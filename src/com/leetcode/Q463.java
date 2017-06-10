package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 
You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example:

[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Answer: 16
Explanation: The perimeter is the 16 yellow stripes in the image below:
  
 
 * 
 * @author mengchaowang
 *
 */
public class Q463 {
	public class Cell {
		int posX, posY;

		public Cell(int x, int y) {
			this.posX = x;
			this.posY = y;
		}
	}

	public int islandPerimeter(int[][] grid) {
		List<Cell> cells = new ArrayList<Cell>();
		for (int x = 0; x < grid.length; x++) {
			for (int y = 0; y < grid[x].length; y++) {
				if (grid[x][y] == 1) {
					cells.add(new Cell(x, y));
				}
			}
		}

		int perimeter = 0;
		for (int i = 0; i < cells.size(); i++) {
			perimeter += getPerimeter(cells.get(i), grid);
		}
		return perimeter;

	}

	private int getPerimeter(Cell cell, int[][] grid) {
		int x = cell.posX;
		int y = cell.posY;
		if (x == 0) {
			if (y == 0) {
				return checkRight(x, y, grid) + checkDown(x, y, grid) + 2;
			} else if (y == grid[x].length - 1) {
				return checkLeft(x, y, grid) + checkDown(x, y, grid) + 2;
			} else {
				return checkRight(x, y, grid) + checkLeft(x, y, grid) + checkDown(x, y, grid) + 1;
			}
		} else if (x == grid.length - 1) {
			if (y == 0) {
				return checkRight(x, y, grid) + checkUp(x, y, grid) + 2;
			} else if (y == grid[x].length - 1) {
				return checkLeft(x, y, grid) + checkUp(x, y, grid) + 2;
			} else {
				return checkRight(x, y, grid) + checkLeft(x, y, grid) + checkUp(x, y, grid) + 1;
			}
		} else {
			if (y == 0) {
				return checkRight(x, y, grid) + checkUp(x, y, grid) + checkDown(x, y, grid) + 1;
			} else if (y == grid[x].length - 1) {
				return checkLeft(x, y, grid) + checkUp(x, y, grid) + checkDown(x, y, grid) + 1;
			} else {
				return checkRight(x, y, grid) + checkLeft(x, y, grid) + checkUp(x, y, grid) + checkDown(x, y, grid);
			}
		}
	}

	private int checkLeft(int x, int y, int[][] grid) {
		if (y == 0)
			return 1;
		return grid[x][y - 1] == 0 ? 1 : 0;
	}

	private int checkRight(int x, int y, int[][] grid) {
		if (y == grid[x].length - 1)
			return 1;
		return grid[x][y + 1] == 0 ? 1 : 0;
	}

	private int checkUp(int x, int y, int[][] grid) {
		if (x == 0)
			return 1;
		return grid[x - 1][y] == 0 ? 1 : 0;
	}

	private int checkDown(int x, int y, int[][] grid) {
		if (x == grid.length - 1)
			return 1;
		return grid[x + 1][y] == 0 ? 1 : 0;
	}
}
