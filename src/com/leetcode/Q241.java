package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 

 Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.


Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]


Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]
  
 * 
 * @author mengchaowang
 *
 */
public class Q241 {
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> re = new ArrayList<Integer>();
		for (int j = input.length(), i = j - 1; i >= 0; i--) {
			char c = input.charAt(i);
			List<Integer> leftList, rightList;
			if (!Character.isDigit(c)) {
				leftList = diffWaysToCompute(input.substring(0, i));
				rightList = diffWaysToCompute(input.substring(i + 1, j));
				re.addAll(getListResult(leftList, rightList, c));
			}
		}
		if (re.size() == 0) {
			re.add(Integer.valueOf(input));
		}
		return re;
	}

	private List<Integer> getListResult(List<Integer> leftList, List<Integer> rightList, char c) {
		List<Integer> re = new ArrayList<>();
		for (int l : leftList) {
			for (int r : rightList) {
				switch (c) {
				case '+':
					re.add(l + r);
					break;
				case '-':
					re.add(l - r);
					break;
				case '*':
					re.add(l * r);
					break;
				}
			}
		}
		return re;
	}

	public static void main(String[] args) {
		Q241 q = new Q241();
		String[] inputs = { "2-1-1", "2*3-4*5", "3" };
		for (String input : inputs) {
			System.out.println(input);
			print(q.diffWaysToCompute(input));
		}
	}

	private static void print(List<Integer> diffWaysToCompute) {
		StringBuilder sb = new StringBuilder("[");
		for (Integer i : diffWaysToCompute) {
			sb.append(i).append(", ");
		}
		sb.delete(sb.length() - 2, sb.length());
		sb.append("]");
		System.out.println(sb.toString());
	}
}
