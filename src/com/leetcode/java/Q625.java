package com.leetcode.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengchaowang on 6/17/17.
 * <p>
 * Given a positive integer a, find the smallest positive integer b whose multiplication of each digit equals to a.
 * <p>
 * If there is no answer or the answer is not fit in 32-bit signed integer, then return 0.
 * <p>
 * Example 1
 * Input:
 * <p>
 * 48
 * Output:
 * 68
 * Example 2
 * Input:
 * <p>
 * 15
 * Output:
 * 35
 */
public class Q625 {

  int min = 0;

  public int smallestFactorization(int a) {
    if (a < 10) {
      return a;
    }
    List<Integer> results = new ArrayList<>();
    findResult(a, results);
    if (results.isEmpty()) {
      return 0;
    } else {
      return min;
    }
  }

  private void findResult(int a, List<Integer> results) {
    int sqrt = (int) Math.ceil(Math.sqrt(a));
    for (int i = sqrt; i >= 2; i--) {
      if (a % i == 0) {
        if (i >= 10) {
          List<Integer> newResults = new ArrayList<>();
          findResult(i, newResults);
          if (newResults.isEmpty()) {
            continue;
          } else {
            results.addAll(newResults);
            int b = a / i;
            if (b >= 10) {
              newResults = new ArrayList<>();
              findResult(b, newResults);
              if (newResults.isEmpty()) {
                continue;
              } else {
                results.addAll(newResults);
                int tmpResult = formNumber(results);
                if (min != 0) {
                  if (tmpResult < min) {
                    min = tmpResult;
                  }
                } else {
                  min = tmpResult;
                }
              }
            } else {
              results.add(b);
              int tmpResult = formNumber(results);
              if (min != 0 && tmpResult < min) {
                min = tmpResult;
              } else {
                min = tmpResult;
              }
            }
          }
        } else {
          results.add(i);
          int b = a / i;
          if (b >= 10) {
            List<Integer> newResults = new ArrayList<>();
            findResult(b, newResults);
            if (newResults.isEmpty()) {
              continue;
            } else {
              results.addAll(newResults);
              int tmpResult = formNumber(results);
              if (min != 0) {
                if (tmpResult < min) {
                  min = tmpResult;
                }
              } else {
                min = tmpResult;
              }
            }
          } else {
            results.add(b);
            int tmpResult = formNumber(results);
            if (min != 0) {
              if (tmpResult < min) {
                min = tmpResult;
              }
            } else {
              min = tmpResult;
            }
          }
        }

      }
    }
  }

  private int formNumber(List<Integer> results) {
    int re = 0;
    for (int i = 0; i < results.size(); i++) {
      re = re + (int) Math.pow(10, i) * results.get(i);
    }
    results.clear();
    return re;
  }


}
