package com.leetcode.java;

/**
 *

 Given two strings representing two complex numbers.

 You need to return a string representing their multiplication. Note i2 = -1 according to the definition.

 Example 1:
 Input: "1+1i", "1+1i"
 Output: "0+2i"
 Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
 Example 2:
 Input: "1+-1i", "1+-1i"
 Output: "0+-2i"
 Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 Note:

 The input strings will not have extra blank.
 The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.

 *
 * @author mengchaowang
 *
 */
public class Q537 {

  public String complexNumberMultiply(String a, String b) {
    int[] aNum = getNum(a);
    int[] bNum = getNum(b);
    int[] reNum = new int[2];
    reNum[0] = aNum[0] * bNum[0] + aNum[1] * bNum[1] * -1;
    reNum[1] = aNum[0] * bNum[1] + aNum[1] * bNum[0];
    String re = "" + reNum[0] + "+" + reNum[1] + "i";
    return re;
  }

  private int[] getNum(String numStr) {
    int plusIdx = numStr.indexOf('+');
    int[] num = new int[2];
    num[0] = Integer.valueOf(numStr.substring(0, plusIdx));
    num[1] = Integer.valueOf(numStr.substring(plusIdx + 1, numStr.length() - 1));
    return num;
  }
}
