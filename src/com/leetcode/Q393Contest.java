package com.leetcode;

/**
 * 
 * A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:

For 1-byte character, the first bit is a 0, followed by its unicode code.
For n-bytes character, the first n-bits are all one's, the n+1 bit is 0, followed by n-1 bytes with most significant 2 bits being 10.
This is how the UTF-8 encoding would work:

   Char. number range  |        UTF-8 octet sequence
      (hexadecimal)    |              (binary)
   --------------------+---------------------------------------------
   0000 0000-0000 007F | 0xxxxxxx
   0000 0080-0000 07FF | 110xxxxx 10xxxxxx
   0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
   0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
Given an array of integers representing the data, return whether it is a valid utf-8 encoding.

Note:
The input is an array of integers. Only the least significant 8 bits of each integer is used to store the data. This means each integer represents only 1 byte of data.

Example 1:

data = [197, 130, 1], which represents the octet sequence: 11000101 10000010 00000001.

Return true.
It is a valid utf-8 encoding for a 2-bytes character followed by a 1-byte character.
Example 2:

data = [235, 140, 4], which represented the octet sequence: 11101011 10001100 00000100.

Return false.
The first 3 bits are all one's and the 4th bit is 0 means it is a 3-bytes character.
The next byte is a continuation byte which starts with 10 and that's correct.
But the second continuation byte does not start with 10, so it is invalid.
 * @author mengchaowang
 *
 */
public class Q393Contest {
	public boolean validUtf8(int[] data) {
		int[][] binary = new int[data.length][8];
		for (int i = 0; i < data.length; i++) {
			// Convert int to binary
			for (int j = 7; j >= 0; j--) {
				binary[i][j] = data[i] & 0x1;
				data[i] = data[i] >> 1;
			}
		}
		print(binary);
		// Get size
		int currentIndex = 0;
		if (!matchPattern(binary[0], 0)) {
			return false;
		}
		int currentSize = getCurrentSize(binary[currentIndex]);
		while (currentIndex < data.length) {
			int end = currentIndex + currentSize;
			if (end > data.length) {
				return false;
			}
			for (int i = currentIndex; i < end; i++) {
				if (!matchPattern(binary[i], i - currentIndex)) {
					return false;
				}
			}
			currentIndex += currentSize;
			if (currentIndex >= data.length) {
				break;
			}
			currentSize = getCurrentSize(binary[currentIndex]);
			if (currentSize == -1) {
				return false;
			}
		}
		return true;
	}

	private int getCurrentSize(int[] is) {
		// Start with 0, size is 1;
		if (is[0] == 0) {
			return 1;
		} else {
			// Start with 1, count 1s.
			int count = 0;
			while (count < 8 && is[count] == 1) {
				count++;
			}
			// All 1s means invalid
			if (count == 8) {
				return -1;
			}
			return count;
		}
	}

	private boolean matchPattern(int[] is, int currentPos) {
		if (currentPos != 0) {
			// Not the first byte
			return is[0] == 1 && is[1] == 0;
		}
		if (currentPos == 0) {
			if (is[0] == 0) {
				return true;
			} else {

				int count = 0;
				while (count < 8 && is[count] == 1) {
					count++;
				}
				// 10
				if (count == 1 || count == 8) {
					return false;
				}
				if (is[count] == 0) {
					return true;
				}
			}
		}
		return false;

	}

	public void print(int[][] binary) {
		for (int i = 0; i < binary.length; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(binary[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Q393Contest q = new Q393Contest();
		// int[] data1 = { 197, 130, 1 };
		// System.out.println(q.validUtf8(data1));
		// int[] data2 = { 235, 140, 4 };
		// System.out.println(q.validUtf8(data2));
		// int[] data3 = { 255 };
		// System.out.println(q.validUtf8(data3));
		// int[] data4 = { 237 };
		// System.out.println(q.validUtf8(data4));
		int[] data5 = { 99, 108, 97, 255, 115, 32, 83, 111, 108, 117, 116, 105, 111, 110, 32, 123, 13, 10, 112, 117, 98,
				108, 105, 99, 58, 13, 10, 32, 32, 32, 32, 98, 111, 111, 108, 32, 118, 97, 108, 105, 100, 95, 117, 116,
				102, 56, 40, 118, 101, 99, 116, 111, 114, 60, 105, 110, 116, 62, 38, 32, 100, 97, 116, 97, 41, 32, 123,
				13, 10, 32, 32, 32, 32, 32, 32, 32, 32, 105, 110, 116, 32, 99, 111, 117, 110, 116, 32, 61, 32, 48, 59,
				13, 10, 32, 32, 32, 32, 9, 102, 111, 114, 40, 97, 117, 116, 111, 32, 99, 32, 58, 32, 100, 97, 116, 97,
				41, 32, 123, 13, 10, 32, 32, 32, 32, 9, 9, 105, 102, 40, 99, 111, 117, 110, 116, 32, 61, 61, 32, 48, 41,
				32, 123, 13, 10, 32, 32, 32, 32, 9, 32, 32, 9, 9, 47, 42, 42, 32, 115, 101, 116, 32, 116, 104, 101, 32,
				114, 101, 109, 97, 105, 110, 101, 100, 32, 116, 104, 101, 32, 117, 116, 102, 45, 56, 32, 99, 104, 97,
				114, 32, 99, 111, 117, 110, 116, 32, 42, 42, 47, 13, 10, 32, 32, 32, 32, 9, 32, 32, 9, 9, 105, 102, 40,
				40, 99, 32, 62, 62, 32, 53, 41, 32, 61, 61, 32, 48, 98, 49, 49, 48, 41, 32, 32, 99, 111, 117, 110, 116,
				32, 61, 32, 49, 59, 13, 10, 32, 32, 32, 32, 9, 32, 32, 9, 9, 101, 108, 115, 101, 32, 105, 102, 40, 40,
				99, 32, 62, 62, 32, 52, 41, 32, 61, 61, 32, 48, 98, 49, 49, 49, 48, 41, 32, 32, 32, 99, 111, 117, 110,
				116, 32, 61, 32, 50, 59, 13, 10, 32, 32, 32, 32, 9, 32, 32, 9, 9, 101, 108, 115, 101, 32, 105, 102, 40,
				40, 99, 32, 62, 62, 32, 51, 41, 32, 61, 61, 32, 48, 98, 49, 49, 49, 49, 48, 41, 32, 32, 99, 111, 117,
				110, 116, 32, 61, 32, 51, 59, 13, 10, 32, 32, 32, 32, 9, 32, 32, 9, 9, 101, 108, 115, 101, 32, 105, 102,
				40, 40, 99, 32, 62, 62, 32, 55, 41, 41, 32, 32, 32, 114, 101, 116, 117, 114, 110, 32, 102, 97, 108, 115,
				101, 59, 13, 10, 32, 32, 32, 32, 9, 32, 32, 9, 125, 32, 101, 108, 115, 101, 32, 123, 13, 10, 32, 32, 32,
				32, 9, 32, 32, 32, 32, 32, 32, 32, 32, 105, 102, 40, 40, 99, 32, 62, 62, 32, 54, 41, 32, 33, 61, 32, 48,
				98, 49, 48, 41, 32, 32, 32, 114, 101, 116, 117, 114, 110, 32, 102, 97, 108, 115, 101, 59, 13, 10, 32,
				32, 32, 32, 9, 32, 32, 32, 9, 9, 99, 111, 117, 110, 116, 45, 45, 59, 13, 10, 32, 32, 32, 32, 9, 32, 32,
				9, 125, 13, 10, 32, 32, 32, 32, 9, 125, 13, 10, 32, 32, 32, 32, 32, 32, 32, 32, 114, 101, 116, 117, 114,
				110, 32, 99, 111, 117, 110, 116, 32, 61, 61, 32, 48, 59, 13, 10, 32, 32, 32, 32, 125, 13, 10, 125, 59,
				13, 10 };
		System.out.println(q.validUtf8(data5));

	}

}
