package com.leetcode.java;

/**
 *
 *

 You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

 Write a function to determine if the starting player can guarantee a win.

 For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".

 * @author mengchaowang
 *
 */
public class Q294Lock {

  public boolean canWin(String s) {
    for (int i = 0; i < s.length() - 1; i++) {
      if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
        if (cannotFlip(s.substring(i + 2)) && cannotFlip(s.substring(0, i))) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean cannotFlip(String substring) {
    if (substring == null || substring.length() < 2) {
      return true;
    }
    for (int i = 0; i < substring.length() - 1; i++) {
      if (substring.charAt(i) == '+' && substring.charAt(i + 1) == '+') {
        return false;
      }
    }
    return true;
  }
}
