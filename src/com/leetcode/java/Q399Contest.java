package com.leetcode.java;

import java.util.HashMap;
import java.util.Map;

/**
 *

 Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

 Example:
 Given a / b = 2.0, b / c = 3.0.
 queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 return [6.0, 0.5, -1.0, 1.0, -1.0 ].

 The input is: vector<pair<string, string>> euqations, vector<double>& values, vector<pair<string, string>> query . where equations.size() == values.size(),the values are positive. this represents the equations.return vector<double>. .
 The example above: equations = [ ["a", "b"], ["b", "c"] ]. values = [2.0, 3.0]. queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].

 The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.

 *
 * @author mengchaowang
 *
 */
public class Q399Contest {

  public double[] calcEquation(String[][] equations, double[] values, String[][] query) {
    double[] result = new double[query.length];
    Map<String, Map<String, Double>> map = new HashMap<String, Map<String, Double>>();
    int count = 0;
    for (int i = 0; i < equations.length; i++) {
      String[] strs = equations[i];
      Map<String, Double> div = map.get(strs[0]);
      if (div == null) {
        div = new HashMap<String, Double>();
      }
      div.put(strs[1], values[i]);
      map.put(strs[0], div);

      Map<String, Double> div2 = map.get(strs[1]);
      if (div2 == null) {
        div2 = new HashMap<String, Double>();
      }
      div2.put(strs[0], 1.0 / values[i]);
      map.put(strs[1], div2);
    }
    // print(map);
    for (String[] strs : query) {
      if (!map.containsKey(strs[0]) || !map.containsKey(strs[1])) {
        result[count++] = -1.0;
      } else if (strs[0].equals(strs[1])) {
        result[count++] = 1.0;
      } else {
        result[count++] = findValue(map, strs[0], strs[1], null);
      }
    }
    return result;
  }

  private static void print(Map<String, Map<String, Double>> map) {
    for (String key : map.keySet()) {
      System.out.print("Key: [" + key + "], Values:[");
      for (String lower : map.get(key).keySet()) {
        System.out.print(lower + " - " + map.get(key).get(lower) + ",");
      }
      System.out.println("]");
    }

  }

  private double findValue(Map<String, Map<String, Double>> map, String upper, String lower,
      String from) {
    System.out.println("Upper: " + upper + ", Lower: " + lower);
    Map<String, Double> values = map.get(upper);
    if (values == null) {
      return -1.0;
    }
    Double value = values.get(lower);
    if (value != null) {
      return value;
    } else {
      for (String newUpper : values.keySet()) {
        if (from != null && from.equals(newUpper)) {
          continue;
        }
        double tmp = findValue(map, newUpper, lower, upper);
        if (tmp != -1.0) {
          return values.get(newUpper) * tmp;
        }
      }
    }
    return -1.0;
  }

  public static void main(String[] args) {
    String[][] equs = {{"x1", "x2"}, {"x2", "x3"}, {"x3", "x4"}, {"x4", "x5"}};
    double[] vals = {3, 4, 5, 6};
    String[][] query = {{"x1", "x5"}, {"x5", "x2"}, {"x2", "x4"}, {"x2", "x2"}, {"x2", "x9"},
        {"x9", "x9"}};

    Q399Contest q = new Q399Contest();
    double[] results = q.calcEquation(equs, vals, query);
    for (double result : results) {
      System.out.print(result + ", ");
    }
  }
}
