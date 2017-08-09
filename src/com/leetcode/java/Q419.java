package com.leetcode.java;

/**
 *

 Given an 2D board, count how many different battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:

 You receive a valid board, made of only battleships or empty slots.
 Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
 At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
 Example:
 X..X
 ...X
 ...X
 In the above board there are 2 battleships.
 Invalid Example:
 ...X
 XXXX
 ...X
 This is an invalid board that you will not receive - as battleships will always have a cell separating between them.

 *
 * @author mengchaowang
 *
 */
public class Q419 {

  public int countBattleships(char[][] board) {
    int count = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == 'X') {
          findship(board, i, j);
          count++;
        } else {
          continue;
        }
      }
    }
    return count;
  }

  private void findship(char[][] board, int i, int j) {

    while (i < board.length - 1 && board[i + 1][j] == 'X') {
      board[i][j] = '.';
      i++;
    }
    while (j < board[i].length - 1 && board[i][j + 1] == 'X') {
      board[i][j] = '.';
      j++;
    }
    board[i][j] = '.';
  }
}
