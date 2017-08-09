package com.leetcode.java;

public class GuessGame {

  private int answer;

  public GuessGame(int answer) {
    this.answer = answer;
  }

  public int guess(int n) {
    if (answer < n) {
      return -1;
    }
    if (answer > n) {
      return 1;
    }
    return 0;

  }
}
