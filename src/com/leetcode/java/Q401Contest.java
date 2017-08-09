package com.leetcode.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *

 A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

 Each LED represents a zero or one, with the least significant bit on the right.

 *
 * @author mengchaowang
 *
 */
public class Q401Contest {

  int[] bits = {1, 2, 4, 8, 1, 2, 4, 8, 16, 32};

  public List<String> readBinaryWatch(int num) {
    List<String> result = new ArrayList<String>();
    calculateTime(num, 0, result, "");
    Collections.sort(result);
    return result;
  }

  public void calculateTime(int num, int start, List<String> result, String tmpResult) {
    if (num <= 0) {
      int length = tmpResult.length();
      for (int i = 0; i <= 9 - length; i++) {
        tmpResult += "0";
      }
      String re = processTime(tmpResult);
      if (re != null) {
        result.add(re);
      }
      return;
    }
    if (10 - start > num) {
      calculateTime(num, start + 1, result, tmpResult + "0");
    }
    calculateTime(num - 1, start + 1, result, tmpResult + "1");
  }

  private String processTime(String tmpResult) {
    // n = 2: 1,0,0,0,0,0,0,0,1
    int hour = 0;
    for (int i = 0; i <= 3; i++) {
      hour += bits[i] * Character.getNumericValue(tmpResult.charAt(i));
    }
    if (hour >= 12) {
      return null;
    }
    String hr = "" + hour;
    int minutes = 0;
    for (int i = 4; i <= 9; i++) {
      minutes += bits[i] * Character.getNumericValue(tmpResult.charAt(i));
    }
    if (minutes >= 60) {
      return null;
    }
    String min = minutes < 10 ? "0" + minutes : "" + minutes;
    return hr + ":" + min;
  }

  public static void main(String[] args) {
    Q401Contest q = new Q401Contest();
    for (String str : q.readBinaryWatch(2)) {
      System.out.println(str);
    }
  }
}
