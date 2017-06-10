package com.leetcode;

/**
 * 
 
There's a tree, a squirrel, and several nuts. Positions are represented by the cells in a 2D grid. Your goal is to find the minimal distance for the squirrel to collect all the nuts and put them under the tree one by one. The squirrel can only take at most one nut at one time and can move in four directions - up, down, left and right, to the adjacent cell. The distance is represented by the number of moves.

Example 1:
Input: 
Height : 5
Width : 7
Tree position : [2,2]
Squirrel : [4,4]
Nuts : [[3,0], [2,5]]
Output: 12
Explanation:

Note:
All given positions won't overlap.
The squirrel can take at most one nut at one time.
The given positions of nuts have no order.
Height and width are positive integers. 3 <= height * width <= 10,000.
The given positions contain at least one nut, only one tree and one squirrel.  
  
 * 
 * @author mengchaowang
 *
 */
public class Q573 {
	public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
		int min = Integer.MAX_VALUE;
		int totalToTreeOneWay = 0;
		for (int i = 0; i < nuts.length; i++) {
			int distanceToSquirrel = getDistance(squirrel, nuts[i]);
			int distanceToTree = getDistanceToTree(tree, nuts[i]);
			totalToTreeOneWay += distanceToTree;
			min = distanceToSquirrel - distanceToTree < min ? distanceToSquirrel - distanceToTree : min;
		}
		return totalToTreeOneWay * 2 + min;
	}

	public int getDistance(int[] obj1, int[] obj2) {
		return Math.abs(obj1[0] - obj1[0]) + Math.abs(obj1[1] - obj2[1]);
	}

	public int getDistanceToTree(int[] tree, int[] obj) {
		return getDistance(tree, obj);
	}
}
