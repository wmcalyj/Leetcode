package com.leetcode;

/* The guess API is defined in the parent class GuessGame.
@param num, your guess
@return -1 if my number is lower, 1 if my number is higher, otherwise return 0
   int guess(int num); */

public class Q374 extends GuessGame {

	public Q374(int answer) {
		super(answer);
	}

	public int guessNumber(int n) {
		long middle = n / 2;
		long low = 1, high = n;
		int answer = guess((int) middle);
		int count = 0;
		while (answer != 0) {
			if (count++ >= 500) {
				break;
			}
			System.out.println("middle - " + middle + ", low - " + low + ", high - " + high);
			if (answer == -1) {
				high = middle;
				middle = (low + high) / 2;
			} else if (answer == 1) {
				low = middle;
				middle = (low + high) / 2 + 1;
			} else {
				return (int) middle;
			}
			answer = guess((int) middle);
		}
		return (int) middle;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int answer = Integer.parseInt(args[1]);
		Q374 solution = new Q374(answer);
		System.out.println(solution.guessNumber(n));
	}
}
