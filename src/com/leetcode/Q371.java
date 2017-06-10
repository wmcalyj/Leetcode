package com.leetcode;

public class Q371 {
	public int getSum(int a, int b) {
		String binaryA = Integer.toBinaryString(a);
		String binaryB = Integer.toBinaryString(b);

		System.out.println("binary a: " + binaryA + "\nbinary b: " + binaryB);

		// int[] result = new int[32];
		// int carry = 0;
		//
		// for (int i = 31; i >= 0; i--) {
		// result[i] = binaryA[i] ^ binaryB[i] ^ carry;
		// if ((binaryA[i] == binaryB[i] && binaryA[i] == 1) || (carry ==
		// (binaryA[i] ^ binaryB[i]) && carry == 1)) {
		// carry = 1;
		// } else {
		// carry = 0;
		// }
		// }
		// String s = "";
		// for (int i = 0; i < 32; i++) {
		// s += result[i];
		// }
		// for (int i = 0; i <= 31; i++) {
		// System.out.print(result[i]);
		// }
		//
		// System.out.println();
		// return Integer.parseInt(s, 2);
		return 1;
	}

	public static void main(String[] args) {
		Q371 q = new Q371();
		q.getSum(-12, -8);
	}
}
