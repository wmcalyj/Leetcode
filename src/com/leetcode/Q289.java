package com.leetcode;

/**
 * 
  
  
 According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.

Follow up: 
Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems? 
  
  
 * @author mengchaowang
 *
 */
public class Q289 {
	public void gameOfLife(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				// -1 means, was live, supposed to be dead
				// 2 means, was dead, supposed to be live
				// 1 means, was live, still live
				// 0 means, was dead, still dead
				board[i][j] = checkSurrondings(i, j, board);
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == -1) {
					board[i][j] = 0;
				}
				if (board[i][j] == 2) {
					board[i][j] = 1;
				}
			}
		}
	}

	private int checkSurrondings(int i, int j, int[][] board) {
		int count = 0;
		int prev = board[i][j];
		int[][] pos = new int[8][2];
		pos[0] = new int[] { i - 1, j - 1 };
		pos[1] = new int[] { i - 1, j };
		pos[2] = new int[] { i - 1, j + 1 };
		pos[3] = new int[] { i, j - 1 };
		pos[4] = new int[] { i, j + 1 };
		pos[5] = new int[] { i + 1, j - 1 };
		pos[6] = new int[] { i + 1, j };
		pos[7] = new int[] { i + 1, j + 1 };
		for (int n = 0; n < 8; n++) {
			if (livePos(pos[n], board)) {
				count++;
			}
			if (count > 3) {
				if (prev == 1) {
					return -1;
				} else {
					return 0;
				}
			}
		}
		if (count < 2) {
			if (prev == 1) {
				return -1;
			} else {
				return 0;
			}
		}
		if (count == 3) {
			if (prev == 0) {
				return 2;
			}
		}
		return prev;
	}

	private boolean livePos(int[] is, int[][] board) {
		if (is[0] >= 0 && is[1] >= 0 && is[0] < board.length && is[1] < board[is[0]].length) {
			return Math.abs(board[is[0]][is[1]]) == 1;
		}
		return false;
	}
}
