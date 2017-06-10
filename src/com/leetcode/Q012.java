package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
  
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
  
 * @author mengchaowang
 *
 */
public class Q012 {
	Roman r = new Roman();

	public String intToRoman(int num) {
		if (num <= 0) {
			return "";
		}
		if (r.dict.get(num) != null) {
			return r.dict.get(num);
		}
		int floor = r.findFloor(num);
		int div = num / floor;
		String tmp = "";
		for (int i = 0; i < div; i++) {
			tmp += r.dict.get(floor);
		}
		tmp += intToRoman(num - div * floor);

		return tmp;
	}

	public class Roman {
		Map<Integer, String> dict;

		public Roman() {
			dict = new HashMap<Integer, String>();
			dict.put(1, "I");
			dict.put(5, "V");
			dict.put(10, "X");
			dict.put(50, "L");
			dict.put(100, "C");
			dict.put(500, "D");
			dict.put(1000, "M");
			dict.put(4, "IV");
			dict.put(9, "IX");
			dict.put(40, "XL");
			dict.put(90, "XC");
			dict.put(400, "CD");
			dict.put(900, "CM");
		}

		public int findFloor(int num) {
			if (num < 4) {
				return 1;
			}
			if (num < 5) {
				return 4;
			}
			if (num < 9) {
				return 5;
			}
			if (num < 10) {
				return 9;
			}
			if (num < 40) {
				return 10;
			}
			if (num < 50) {
				return 40;
			}
			if (num < 90) {
				return 50;
			}
			if (num < 100) {
				return 90;
			}
			if (num < 400) {
				return 100;
			}
			if (num < 500) {
				return 400;
			}
			if (num < 900)
				return 500;
			if (num < 1000)
				return 900;
			return 1000;
		}
	}

	public static void main(String[] args) {
		Q012 q = new Q012();
		System.out.println(q.intToRoman(1));
	}
}
