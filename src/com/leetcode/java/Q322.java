package com.leetcode.java;

import java.util.HashMap;
import java.util.Map;

/**
 *

 You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

 Example 1:
 coins = [1, 2, 5], amount = 11
 return 3 (11 = 5 + 5 + 1)

 Example 2:
 coins = [2], amount = 3
 return -1.

 Note:
 You may assume that you have an infinite number of each kind of coin.



 *
 * @author mengchaowang
 *
 */
public class Q322 {

  Map<Integer, Integer> cache = new HashMap<Integer, Integer>();

  public int coinChange(int[] coins, int amount) {
    Integer min = null;
    if (amount == 0) {
      return 0;
    }
    if (amount < 0) {
      return -1;
    }

    if (cache.containsKey(amount)) {
      return cache.get(amount);
    } else {
      for (int i = coins.length - 1; i >= 0; i--) {
        if (amount >= coins[i]) {
          int tmp = coinChange(coins, amount - coins[i]) + 1;
          if (tmp > 0) {
            if (min == null) {
              min = tmp;
            } else {
              min = Math.min(min, tmp);
            }
          } else {
            continue;
          }
        }
      }
      if (min == null) {
        cache.put(amount, -1);
      } else {
        cache.put(amount, min);
      }

    }
    return min == null ? -1 : min;
  }

  public void clear() {
    this.cache.clear();
  }

  public static void main(String[] args) {

    Q322 q = new Q322();
    System.out.println(q.coinChange(new int[]{186, 419, 83, 408}, 6249));
    q.clear();
    System.out.println(q.coinChange(new int[]{1, 3}, 3));

  }
}
