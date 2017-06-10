package com.leetcode;

/**
 * 
  
 You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

For example, given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4 
  
 * 
 * @author mengchaowang
 *
 */
public class Q286 {
	public void wallsAndGates(int[][] rooms) {
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				if (rooms[i][j] == 0) {
					expand(rooms, i, j, 0);
				}
			}
		}
	}

	public void expand(int[][] rooms, int x, int y, int distance) {
		if (x < 0 || x >= rooms.length || y < 0 || y >= rooms[x].length) {
			return;
		}
		if ((distance != 0 && rooms[x][y] == 0) || rooms[x][y] == -1) {
			return;
		}
		if (rooms[x][y] < distance) {
			return;
		}
		rooms[x][y] = distance;
		expand(rooms, x - 1, y, distance + 1);
		expand(rooms, x + 1, y, distance + 1);
		expand(rooms, x, y - 1, distance + 1);
		expand(rooms, x, y + 1, distance + 1);
	}

	public static void main(String[] args) {
		int[][] rooms = { { 2147483647, -1, 0, 2147483647 }, { 2147483647, 2147483647, 2147483647, -1 },
				{ 2147483647, -1, 2147483647, -1 }, { 0, -1, 2147483647, 2147483647 } };
		Q286 q = new Q286();
		q.wallsAndGates(rooms);
	}
}
