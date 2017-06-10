package com.leetcode;

/**
 * 
  
 A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2. 
  
 * 
 * @author mengchaowang
 *
 */
public class Q091 {
	public int numDecodings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		if (s.length() == 1) {
			return s.equals("0") ? 0 : 1;
		}
		if (s.length() == 2) {
			if (Integer.valueOf(s) == 0) {
				return 0;
			}
			if (s.charAt(1) == '0') {
				return Integer.valueOf(s) > 26 ? 0 : 1;
			} else {
				return Integer.valueOf(s) > 26 ? 1 : 2;
			}
		}
		int left = numDecodings(s.substring(0, 2));
		int right = numDecodings(s.substring(2));
		if(left == 0 || right == 0){
			return 0;
		}
		return left + right;
	}

	public static void main(String[] args) {
		Q091 q = new Q091();
		System.out.println(q.numDecodings("12"));
	}
}
