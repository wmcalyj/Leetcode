package com.leetcode.java;

/**


 Let's play the minesweeper game (Wikipedia, online game)!

 You are given a 2D char matrix representing the game board. 'M' represents an unrevealed mine, 'E' represents an unrevealed empty square, 'B' represents a revealed blank square that has no adjacent (above, below, left, right, and all 4 diagonals) mines, digit ('1' to '8') represents how many mines are adjacent to this revealed square, and finally 'X' represents a revealed mine.

 Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'), return the board after revealing this position according to the following rules:

 If a mine ('M') is revealed, then the game is over - change it to 'X'.
 If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
 If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
 Return the board when no more squares will be revealed.
 Example 1:
 Input:

 [['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'M', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E']]

 Click : [3,0]

 Output:

 [['B', '1', 'E', '1', 'B'],
 ['B', '1', 'M', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

 Explanation:

 Example 2:
 Input:

 [['B', '1', 'E', '1', 'B'],
 ['B', '1', 'M', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

 Click : [1,2]

 Output:

 [['B', '1', 'E', '1', 'B'],
 ['B', '1', 'X', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

 Explanation:

 Note:
 The range of the input matrix's height and width is [1,50].
 The click position will only be an unrevealed square ('M' or 'E'), which also means the input board contains at least one clickable square.
 The input board won't be a stage when game is over (some mines have been revealed).
 For simplicity, not mentioned rules should be ignored in this problem. For example, you don't need to reveal all the unrevealed mines when the game is over, consider any cases that you will win the game or flag any squares.

 */

public class Q529 {

  public char[][] updateBoard(char[][] board, int[] click) {
    char clickedChar = board[click[0]][click[1]];
    switch (clickedChar) {
      case 'M': //Unrevealed Mine
        board[click[0]][click[1]] = 'X';
        return board;
      case 'E':// Unrevealed Empty Square
        explore(board, click[0], click[1]);
        return board;
      default:
        return board;
    }
  }

  private void explore(char[][] board, int currentI, int currentJ) {
    // Check boundaries.
    if (currentI < 0 || currentJ < 0) {
      return;
    }
    if (currentI >= board.length || currentJ >= board[currentI].length) {
      return;
    }
    // Check if it's already revealed.
    if (board[currentI][currentJ] == 'B') {
      return;
    }
    // If it's not already revealed, calculate number.
    checkAllEightPosition(board, currentI, currentJ);
    // If the current position has number, stop and return
    if (Character.isDigit(board[currentI][currentJ])) {
      return;
    }

    // Explore the surrounding 8 positions
    explore(board, currentI - 1, currentJ - 1);
    explore(board, currentI - 1, currentJ);
    explore(board, currentI - 1, currentJ + 1);
    explore(board, currentI, currentJ - 1);
    explore(board, currentI, currentJ + 1);
    explore(board, currentI + 1, currentJ - 1);
    explore(board, currentI + 1, currentJ);
    explore(board, currentI + 1, currentJ + 1);


  }

  private void checkAllEightPosition(char[][] board, int currentI, int currentJ) {
    int count = 0;
    if (checkIsM(board, currentI - 1, currentJ - 1)) {
      count++;
    }
    if (checkIsM(board, currentI - 1, currentJ)) {
      count++;
    }
    if (checkIsM(board, currentI - 1, currentJ + 1)) {
      count++;
    }
    if (checkIsM(board, currentI, currentJ - 1)) {
      count++;
    }
    if (checkIsM(board, currentI, currentJ + 1)) {
      count++;
    }
    if (checkIsM(board, currentI + 1, currentJ - 1)) {
      count++;
    }
    if (checkIsM(board, currentI + 1, currentJ)) {
      count++;
    }
    if (checkIsM(board, currentI + 1, currentJ + 1)) {
      count++;
    }
    if (count == 0) {
      board[currentI][currentJ] = 'B';
    } else {
      board[currentI][currentJ] = (char) ('0' + count);
    }

  }

  private boolean checkIsM(char[][] board, int i, int j) {
    if (i < 0 || j < 0) {
      return false;
    }
    if (i >= board.length) {
      return false;
    }
    if (j >= board[i].length) {
      return false;
    }
    return board[i][j] == 'M';
  }
}
