package com.leetcode.java;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *

 Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

 Examples:
 "123", 6 -> ["1+2+3", "1*2*3"]
 "232", 8 -> ["2*3+2", "2+3*2"]
 "105", 5 -> ["1*0+5","10-5"]
 "00", 0 -> ["0+0", "0-0", "0*0"]
 "3456237490", 9191 -> []

 *
 *
 * @author mengchaowang
 *
 */
public class Q282 {

  public List<String> addOperators(String num, int target) {
    List<String> re = new ArrayList<String>();
    String c = "" + num.charAt(0);
    addOperators(num, target, "", re);
    return re;
  }

  private void addOperators(String num, int target, String tmpResult, List<String> re) {
    if (num == null || num.length() == 0) {
      if (target == eval(tmpResult)) {
        re.add(tmpResult);
      }
      return;
    }
    String c = "" + num.charAt(0);

    addOperators(num.substring(1), target, tmpResult + "+" + c, re);
    addOperators(num.substring(1), target, tmpResult + "-" + c, re);
    addOperators(num.substring(1), target, tmpResult + "*" + c, re);

  }

  private int eval(String tmpResult) {
    // TODO Auto-generated method stub
    return 0;
  }

  public static void main(String[] args) {
    Q282 q = new Q282();
    String[] nums = {"123", "232", "105", "00"};
    int[] targets = {6, 8, 5, 0};
    for (int i = 0; i < nums.length; i++) {
      print(q.addOperators(nums[i], targets[i]));
    }
  }

  private static void print(List<String> addOperators) {
    StringBuilder sb = new StringBuilder("[");
    for (String str : addOperators) {
      sb.append(str).append(", ");
    }
    if (sb.length() > 1) {
      sb.delete(sb.length() - 2, sb.length());
    }
    sb.append("]");
    System.out.println(sb.toString());
  }
}
