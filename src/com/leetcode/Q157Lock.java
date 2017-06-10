package com.leetcode;

/**
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * 
 * The return value is the actual number of characters read. For example, it
 * returns 3 if there is only 3 characters left in the file.
 * 
 * By using the read4 API, implement the function int read(char *buf, int n)
 * that reads n characters from the file.
 * 
 * Note: The read function will only be called once for each test case.
 * 
 * @author mengchaowang
 *
 */
public class Q157Lock {
	/**
	 * @param buf
	 *            Destination buffer
	 * @param n
	 *            Maximum number of characters to read
	 * @return The number of characters read
	 */
	public int read(char[] buf, int n) {
		int count = 0;
		char[] copy = new char[4];
		int prevC = read4(buf);
		for (int i = 0; i < prevC; i++) {
			copy[i] = buf[i];
		}
		n = n - prevC;
		count += prevC;
		while (n > 0) {
			int newC = read4(buf);
			for (int i = 0; i < newC; i++) {
				buf[count + i] = buf[i];
			}
			for (int i = 0; i < prevC; i++) {
				buf[i] = copy[i];
			}
			prevC = newC;
			n -= newC;
			count += newC;
			if (n <= 0 || newC < 4) {
				break;
			}
		}
		if (n < 0) {
			for (int i = count + n; i < count; i++) {
				buf[i] = 0;
			}
			count += n;
		}
		return count;
	}
}
