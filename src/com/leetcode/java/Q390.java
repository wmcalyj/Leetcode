package com.leetcode.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *

 There is a list of sorted integers from 1 to n. Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.

 Repeat the previous step again, but this time from right to left, remove the right most number and every other number from the remaining numbers.

 We keep repeating the steps again, alternating left to right and right to left, until a single number remains.

 Find the last number that remains starting with a list of length n.

 Example:

 Input:
 n = 9,
 1 2 3 4 5 6 7 8 9
 2 4 6 8
 2 6
 6

 Output:
 6


 * @author mengchaowang
 *
 */
public class Q390 {

  public int lastRemaining(int n) {
    List<Integer> list = new LinkedList<Integer>();
    for (int i = 1; i <= n; i++) {
      list.add(i);
    }
    List<Integer> obj = new ArrayList<>();
    int idx = 0;
    boolean right = true;
    while (list.size() > 1) {
      obj.add(list.get(idx));
      if (right) {
        idx = idx + 2;
      } else {
        idx = idx - 2;
      }
      if (idx >= list.size()) {
        clearObj(list, obj);
        right = false;
        idx = list.size() - 1;
      }
      if (idx < 0) {
        clearObj(list, obj);
        right = true;
        idx = 0;
      }
    }
    return list.get(0);
  }

  private void clearObj(List<Integer> list, List<Integer> obj) {
    for (Integer o : obj) {
      list.remove(o);
    }
    obj.removeAll(obj);
  }

  private void print(List<Integer> list) {
    StringBuilder sb = new StringBuilder("[");
    for (int i = 0; i < list.size(); i++) {
      sb.append(list.get(i)).append(",");
    }
    sb.delete(sb.length() - 1, sb.length()).append("]");
    System.out.println(sb.toString());
  }

  public static void main(String[] args) {
    Q390 q = new Q390();
    System.out.println(q.lastRemaining(9));
  }
}
