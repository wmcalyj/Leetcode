package com.leetcode;

/**
 * 
  
 Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.

Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]] 
  
 * 
 * @author mengchaowang
 *
 */
public class Q406Contest {
	public int[][] reconstructQueue(int[][] people) {
		if (people == null || people.length == 0 || people[0].length == 0) {
			return new int[0][0];
		}
		int count = 0;
		int[][] result = new int[people.length][2];
		int initIdx = -1;
		int[] idxes = new int[people.length];
		int[][] peopleCopy = new int[people.length][2];
		for (int i = 0; i < people.length; i++) {
			peopleCopy[i][0] = people[i][0];
			peopleCopy[i][1] = people[i][1];
		}
		while (count < people.length) {
			for (int i = 0; i < people.length; i++) {
				if (people[i][1] == 0) {
					if (initIdx == -1) {
						initIdx = i;
					} else {
						if (people[i][0] < people[initIdx][0]) {
							initIdx = i;
						}
					}
				}
			}
			idxes[count] = initIdx;
			count++;
			int h = people[initIdx][0];
			people[initIdx][0] = -1;
			people[initIdx][1] = -1;

			for (int i = 0; i < people.length; i++) {
				if (people[i][0] != -1 && people[i][1] != -1) {
					if (people[i][0] <= h) {
						people[i][1]--;
					}
				}
			}
			initIdx = -1;
		}
		for (int i = 0; i < people.length; i++) {
			result[i][0] = peopleCopy[idxes[i]][0];
			result[i][1] = peopleCopy[idxes[i]][1];
		}

		return result;
	}

	public static void main(String[] args) {
		Q406Contest q = new Q406Contest();
		int[][] people = { {} };
		int[][] result = q.reconstructQueue(people);
		for (int i = 0; i < result.length; i++) {
			System.out.print("[" + result[i][0] + "," + result[i][1] + "], ");
		}
	}
}
