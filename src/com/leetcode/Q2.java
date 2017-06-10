package com.leetcode;

/**
 * 
 * 
  
 Given an array of scores that are non-negative integers. Player 1 picks one of the numbers from either end of the array followed by the player 2 and then player 1 and so on. Each time a player picks a number, that number will not be available for the next player. This continues until all the scores have been chosen. The player with the maximum score wins.

Given an array of scores, predict whether player 1 is the winner. You can assume each player plays to maximize his score.

Example 1:
Input: [1, 5, 2]
Output: False
Explanation: Initially, player 1 can choose between 1 and 2. 
If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2). 
So, final score of player 1 is 1 + 2 = 3, and player 2 is 5. 
Hence, player 1 will never be the winner and you need to return False.
Example 2:
Input: [1, 5, 233, 7]
Output: True
Explanation: Player 1 first chooses 1. Then player 2 have to choose between 5 and 7. No matter which number player 2 choose, player 1 can choose 233.
Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.
Note:
1 <= length of the array <= 20.
Any scores in the given array are non-negative integers and will not exceed 10,000,000.
If the scores of both players are equal, then player 1 is still the winner. 
  
 * 
 * @author mengchaowang
 *
 */
public class Q2 {
	private boolean canWin = false;
	int maxP1 = -1;
	int maxP2 = -2;

	public boolean PredictTheWinner(int[] nums) {
		int p1 = 0;
		int p2 = 0;
		if (nums == null || nums.length == 0) {
			return true;
		}
		playerOnePicks(nums, 0, nums.length - 1, p1, p2);
		return canWin;
	}

	private void playerOnePicks(int[] nums, int head, int tail, int p1, int p2) {
		if (head > tail) {
			if (p1 >= p2) {
				canWin = true;
			}
			return;
		}
		// Pick head
		playerTwoPicks(nums, head + 1, tail, p1 + nums[head], p2);
		playerTwoPicks(nums, head, tail - 1, p1 + nums[tail], p2);
	}

	private void playerTwoPicks(int[] nums, int head, int tail, int p1, int p2) {
		// TODO Auto-generated method stub
		if (head > tail) {
			if (p1 >= p2) {
				canWin = true;
			}
			return;
		}
		if (p1 + nums[head] >= p2 + nums[tail]) {
			playerOnePicks(nums, head + 1, tail, p1, p2 + nums[head]);
		} else {
			playerOnePicks(nums, head, tail - 1, p1, p2 + nums[tail]);
		}

	}

	public static void main(String[] args) {
		Q2 q = new Q2();
		int[][] tests = { { 1, 5, 2 }, { 1, 5, 233, 7 },
				{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 }, { 2, 4, 55, 6, 8 } };
		for (int[] test : tests) {
			System.out.println(q.PredictTheWinner(test));
		}
	}
}
