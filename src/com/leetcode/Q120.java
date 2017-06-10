package com.leetcode;

import java.util.List;

/**
 * 
 * 
  
 Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle. 
  
 * 
 * 
 * @author mengchaowang
 *
 */
public class Q120 {
	public int minimumTotal(List<List<Integer>> triangle) {
		int[] ways = new int[triangle.size()];
		for (int i = triangle.size() - 1; i >= 1; i--) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				ways[j]
			}
		}
	}
}
