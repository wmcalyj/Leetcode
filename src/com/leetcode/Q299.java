package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.

For example:

Secret number:  "1807"
Friend's guess: "7810"
Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B".

Please note that both secret number and friend's guess may contain duplicate digits, for example:

Secret number:  "1123"
Friend's guess: "0111"
In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 
 * @author mengchaowang
 *
 */
public class Q299 {
	public String getHint(String secret, String guess) {
		char[] gArray = guess.toCharArray();
		char[] sArray = secret.toCharArray();

		int A = 0, B = 0;
		Map<Character, Integer> original = new HashMap<Character, Integer>();

		for (int i = 0; i < gArray.length; i++) {
			if (gArray[i] == sArray[i]) {
				A++;
				gArray[i] = 0;
			} else {
				Integer count = original.get(sArray[i]);
				if (count == null) {
					original.put(sArray[i], 1);
				} else {
					original.put(sArray[i], count + 1);
				}
			}
		}
		for (int i = 0; i < gArray.length; i++) {
			if (gArray[i] != 0 && original.containsKey(gArray[i])) {
				B++;
				Integer count = original.get(gArray[i]);
				if (count == 1) {
					original.remove(gArray[i]);
				} else {
					original.put(gArray[i], count - 1);
				}
			}
		}
		return A + "A" + B + "B";
	}

}
