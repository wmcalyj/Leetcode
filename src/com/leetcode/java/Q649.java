package com.leetcode.java;
// @formatter:off

/**
 * Created by mengchaowang on 8/7/17.



 */

// @formatter:on
public class Q649 {

  final static int Radiant = -1;
  final static int Dire = 1;
  final static int Banned = 0;

  public String predictPartyVictory(String senate) {
    int[] senates = new int[senate.length()];
    for (int i = 0; i < senate.length(); i++) {
      switch (senate.charAt(i)) {
        case 'R':
          senates[i] = Radiant;
          break;
        case 'D':
          senates[i] = Dire;
      }
    }
    while (true) {
      for (int i = 0; i < senates.length; i++) {
        boolean allClear = true;
        if (senates[i] == Radiant) {
          for (int j = i + 1; j < senates.length; j++) {
            if (senates[j] == Dire) {
              senates[j] = Banned;
              allClear = false;
              break;
            }
          }
        }
        if (senates[i] == Dire) {
          for (int j = i + 1; j < senates.length; j++) {
            if (senates[j] == Radiant) {
              senates[j] = Banned;
              allClear = false;
              break;
            }
          }
        }
        if (allClear) {
          if (senates[i] == Radiant) {
            return "Radiant";
          }
          if (senates[i] == Dire) {
            return "Dire";
          }
        }

      }
    }
  }
}
