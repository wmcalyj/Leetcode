package com.leetcode.java;

/**
 *

 Reverse bits of a given 32 bits unsigned integer.

 For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

 Follow up:
 If this function is called many times, how would you optimize it?

 Related problem: Reverse Integer

 * @author mengchaowang
 *
 */
public class Q190 {

  public int reverseBits(int n) {
    if (n >= Integer.MAX_VALUE) {
      return n;
    }
    String original = Integer.toBinaryString(n);
    StringBuilder target = new StringBuilder();
    for (int j = original.length(), i = j - 1; i >= 0; i--) {
      target = target.append(original.charAt(i));
    }
    for (int i = 0; i < 32 - original.length(); i++) {
      target.append(0);
    }
    System.out.println("target: " + target);
    String t = target.toString();
    long r = 0;
    for (int j = t.length() - 1, i = j; i >= 0; i--) {
      int c = t.charAt(i) - '0';
      r += Math.pow(2, j - i) * c;
    }
    return (int) r;
  }

  public static void main(String[] args) {
    Q190 q = new Q190();
    System.out.println(q.reverseBits(1));
    long n = 4294967295L;
    System.out.println(q.reverseBits((int) n));
  }
}
