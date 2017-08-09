package com.leetcode.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 *

 Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, count the total number of unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.

 Rules for a valid pattern:
 Each pattern must connect at least m keys and at most n keys.
 All the keys must be distinct.
 If the line connecting two consecutive keys in the pattern passes through any other keys, the other keys must have previously selected in the pattern. No jumps through non selected key is allowed.
 The order of keys used matters.

 Explanation:
 | 1 | 2 | 3 |
 | 4 | 5 | 6 |
 | 7 | 8 | 9 |
 Invalid move: 4 - 1 - 3 - 6
 Line 1 - 3 passes through key 2 which had not been selected in the pattern.

 Invalid move: 4 - 1 - 9 - 2
 Line 1 - 9 passes through key 5 which had not been selected in the pattern.

 Valid move: 2 - 4 - 1 - 3 - 6
 Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern

 Valid move: 6 - 5 - 4 - 1 - 9 - 2
 Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.

 Example:
 Given m = 1, n = 1, return 9.

 *
 * @author mengchaowang
 *
 */
public class Q351Lock {

  public int numberOfPatterns(int m, int n) {
    Set<Integer> visited = new HashSet<Integer>();
    Map<Integer, Set<Integer>> connected = new HashMap<Integer, Set<Integer>>();

    Integer[][] patterns = {{}, {2, 4, 5, 6, 8}, {1, 3, 4, 5, 6, 7, 9}, {2, 4, 5, 6, 8},
        {1, 2, 3, 5, 7, 8, 9}, {1, 2, 3, 4, 6, 7, 8, 9}, {1, 2, 3, 5, 7, 8, 9}, {2, 4, 5, 6, 8},
        {1, 3, 4, 5, 6, 7, 9}, {2, 4, 5, 6, 8}};
    for (int i = 1; i <= 9; i++) {
      connected.put(i, new HashSet<Integer>(Arrays.asList(patterns[i])));
    }
    int result = 0;
    for (int i = m; i <= n; i++) {
      for (int j = 1; j <= 9; j++) {
        visited.add(j);
        System.out.print(j + "{");
        int tmp = numberOfPatterns(connected, j, i - 1, visited);
        System.out.println(tmp);
        result = result + tmp;
        System.out.println("}");
        visited.remove(j);
      }
    }
    return result;
  }

  public int numberOfPatterns(Map<Integer, Set<Integer>> connected, int currentPos, int n,
      Set<Integer> visited) {

    System.out.print(currentPos + " -> ");
    if (n == 0) {
      System.out.println(" ||");
      return 0;

    }
    Set<Integer> possibleNext = new HashSet<Integer>();
    possibleNext.addAll(connected.get(currentPos));

    if (visited.contains(2) && (currentPos == 1 || currentPos == 3)) {
      possibleNext.add(4 - currentPos);
    }
    if (visited.contains(8) && (currentPos == 7 || currentPos == 9)) {
      possibleNext.add(16 - currentPos);
    }
    if (visited.contains(4) && (currentPos == 1 || currentPos == 7)) {
      possibleNext.add(8 - currentPos);
    }
    if (visited.contains(6) && (currentPos == 3 || currentPos == 9)) {
      possibleNext.add(12 - currentPos);
    }
    int result = 0;
    for (int i : possibleNext) {
      if (!visited.contains(i)) {
        visited.add(i);
        result = result + numberOfPatterns(connected, i, n - 1, visited) + 1;
        visited.remove(i);
      }
    }
    return result;

  }

  public static void main(String[] args) {
    Q351Lock q = new Q351Lock();
    System.out.println(q.numberOfPatterns(3, 3));

  }
}
