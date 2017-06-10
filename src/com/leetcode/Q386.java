package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
  
 Given an integer n, return 1 - n in lexicographical order.

For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].

Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.

 
  
 * 
 * 
 * @author mengchaowang
 *
 */
public class Q386 {
	public List<Integer> lexicalOrder(int n) {
		String[] strs = new String[n];
		for (int i = 0; i < n; i++) {
			strs[i] = "" + i;
		}
		Arrays.sort(strs);
		List<Integer> re = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			re.add(Integer.valueOf(strs[i]));
		}
		return re;
	}
}
